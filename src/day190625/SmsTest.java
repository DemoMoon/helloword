package day190625;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class SmsTest {
    private final static String MSMSADB_MSMS_APPINFO_SQL = "USE [MSMSADB]\n" +
            "GO\n" +
            "\n" +
            "SET ANSI_NULLS ON;\n" +
            "GO\n" +
            "\n" +
            "SET QUOTED_IDENTIFIER ON;\n" +
            "GO\n" +
            "\n" +
            "\n" +
            "IF NOT EXISTS(SELECT * FROM [MSMSADB].[dbo].[MSMS_AppInfo] WHERE [id]= '%s' and [appdesc] ='Imps.%sGateway.' )\n" +
            "BEGIN\n" +
            "INSERT [dbo].[MSMS_AppInfo] ([id], [appdesc], [ip]) VALUES (N'%s', N'Imps.%sGateway.', NULL)\n" +
            "END\n" +
            "GO";
    private final static String MSMSADB_MSMS_APPMTCONFIG_SQL = "USE [MSMSADB]\n" +
            "GO\n" +
            "\n" +
            "SET ANSI_NULLS ON;\n" +
            "GO\n" +
            "\n" +
            "SET QUOTED_IDENTIFIER ON;\n" +
            "GO\n" +
            " \n" +
            "\n" +
            "IF EXISTS(SELECT * FROM [MSMSADB].[dbo].[MSMS_APPMtConfig] WHERE [id]= '%s' AND [appId]='Imps.%sGateway.' )\n" +
            "BEGIN\n" +
            "\tDELETE FROM [dbo].[MSMS_APPMtConfig] WHERE [id]='%s' AND [appId]='Imps.%sGateway.'\n" +
            "END\n" +
            "\n" +
            "INSERT [dbo].[MSMS_APPMtConfig] ([id], [appId], [tagId], [send], [isCheck], [version], [apptype], [isIPCheck]) VALUES (N'%s', N'Imps.%sGateway.',%s, '%s', 0, getdate(), 0, 0)\n" +
            "\n" +
            "GO\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n";
    private final static String SMS_APPCONFIG_INSERT_SQL = "USE SMSADB\n" +
            "GO\n" +
            "\n" +
            "SET ANSI_NULLS ON;\n" +
            "GO\n" +
            "\n" +
            "SET QUOTED_IDENTIFIER ON;\n" +
            "GO\n" +
            "\n" +
            "IF EXISTS(SELECT * FROM [SMSADB].[dbo].[SMS_APPConfig] WHERE [id] = 'Imps.%sGateway.' )\n" +
            "BEGIN\n" +
            "\tDELETE FROM [SMSADB].[dbo].[SMS_APPConfig] WHERE [id] = 'Imps.%sGateway.'\n" +
            "end\n" +
            "\n" +
            "INSERT INTO [SMSADB].[dbo].[SMS_APPConfig]\n" +
            "           ([id]\n" +
            "           ,[callback]\n" +
            "           ,[send]\n" +
            "           ,[receive]\n" +
            "           ,[version]\n" +
            "           ,[apptype])\n" +
            "     VALUES\n" +
            "           ('Imps.%sGateway.'\n" +
            "           ,''\n" +
            "           ,'%s'\n" +
            "           ,'%s'\n" +
            "           ,getdate()\n" +
            "           ,0)\n" +
            "GO\n";

    private final static String MSMSADB_MSMS_APPMOCONFIG_SQL = "USE [MSMSADB]\n" +
            "GO\n" +
            "\n" +
            "SET ANSI_NULLS ON;\n" +
            "GO\n" +
            "\n" +
            "SET QUOTED_IDENTIFIER ON;\n" +
            "GO\n" +
            "\n" +
            "\n" +
            "IF NOT EXISTS(SELECT * FROM [MSMSADB].[dbo].[MSMS_APPMoConfig] WHERE [id]= '%s')\n" +
            "BEGIN\n" +
            "INSERT [dbo].[MSMS_APPMoConfig] ([id], [callback], [receive], [version]) VALUES (N'%s', N'RPC:tcp://172.21.43.2:7014', '%s', getdate())\n" +
            "END\n" +
            "GO\n";

    public static void main(String[] args) throws IOException {
        int tagId = 138;
        String[] numbers = {"080", "081", "082", "083", "084", "085", "086", "087", "089", "090", "091", "092", "093", "094", "095", "096", "097", "098", "099", "123", "955"};
        String filePath="";
        //String[] numbers = {"080"};
        for (String number : numbers) {
            String uuid = UUID.randomUUID().toString();
            String downSms = filePath + File.separator + number + File.separator + "下行";
            String msmsadbMsmsAppinfoSql = String.format(SmsTest.MSMSADB_MSMS_APPINFO_SQL, uuid, number, uuid, number);
            fileOut(downSms + File.separator + String.format("MSMSADB_MSMS_AppInfo_Add_%sGateway_生产.sql", number), msmsadbMsmsAppinfoSql);
            String msmsadbMsmsAppmtconfigSql = String.format(SmsTest.MSMSADB_MSMS_APPMTCONFIG_SQL, uuid, number, uuid, number, uuid, number, ++tagId, number);
            fileOut(downSms + File.separator + String.format("MSMSADB_MSMS_APPMtConfig_Add_%sGateway_生产.sql", number), msmsadbMsmsAppmtconfigSql);
            String smsAppconfigInsertSql = String.format(SmsTest.SMS_APPCONFIG_INSERT_SQL, number, number, number, number, number);
            fileOut(downSms + File.separator + String.format("SMS_APPCONFIG_INSERT_%sGateWay_生产.sql", number), smsAppconfigInsertSql);
            String msmsadbMsmsAppmoconfigSql = String.format(SmsTest.MSMSADB_MSMS_APPMOCONFIG_SQL, uuid, uuid, number);
            String upSms = filePath + File.separator + number + File.separator + "上行";
            fileOut(upSms + File.separator + String.format("MSMSADB_MSMS_APPMoConfig_Add_%sGateway_生产.sql", number), msmsadbMsmsAppmoconfigSql);
        }
    }

    private static void fileOut(String filePath, String content) throws IOException {
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            return;
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(content.getBytes(StandardCharsets.UTF_8));
        fileOutputStream.close();
    }
}
