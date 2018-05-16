package day0509;

public class Test {
    public static void main(String[] args) {
        for(int i=0;i<32;i++){
            for(int j=0;j<256;j++){
                if(j%32==i){
                    System.out.println(j);
                }
            }
        }
    }
}
