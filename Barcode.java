public class Barcode{
    static String completeBarcode(String barcodePrefix){
        for(int i = 0; i<barcodePrefix.length();i++){ //Characters are not digits
            Character letter = barcodePrefix.charAt(i);
            if(!Character.isDigit(letter)){
                System.out.println("Invalid barcode prefix");
                return barcodePrefix;
            }
        }
        if(barcodePrefix.length()!=12 && barcodePrefix.length()!=7){ //Condition: Not accurate length
            System.out.println("Invalid barcode prefix");
            return barcodePrefix;
        }

        else{
            String reversebarcode = "";
            char[] result = barcodePrefix.toCharArray();
            for(int i = result.length-1;i>=0;i--){
                reversebarcode = reversebarcode+result[i];  //reversebarcode string that is reversed
            }
            //System.out.println(reversebarcode);
            int checksum = 0;
            int evenodd = 0;
            int count = 0;
            int even = 3;
            int odd = 1;
            for(char ch: reversebarcode.toCharArray()){
                if(evenodd % 2==0){
                    System.out.println("this");
                    count = ch*even; //temp variable
                    System.out.println(count + " Count");
                    checksum += count;
                    evenodd +=1;
                    System.out.println(checksum + " Sum");
                    count = 0;
                }
                else{
                    System.out.println("that");
                    count = ch*odd;
                    checksum +=count;
                    evenodd +=1;
                    count = 0;
                }
                
            }
        }
        return barcodePrefix;
    }
    public static void main(String[] args) throws Exception {
        completeBarcode("400638133393");
    }
}

// 400638133393 (normal)
// 393331836004 (reverse)