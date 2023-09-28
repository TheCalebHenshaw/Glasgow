    static String completeBarcode(String barcodePrefix){
        int barcodeLength = barcodePrefix.length();
        if(barcodeLength!=12 && barcodeLength !=7){
            System.out.println("Invalid barcode prefix");
            return barcodePrefix;
        }
        for(char ch: barcodePrefix.toCharArray()){
            if(!Character.isDigit(ch)){
                System.out.println("Invalid barcode prefix");
                return barcodePrefix;
            }
        }
        int sum = 0;
        int multiplier = 3;
        for(int i = barcodeLength - 1;i>=0;i--){
            char characterNumber = barcodePrefix.charAt(i);
            int numberValue = Character.getNumericValue(characterNumber);
            if(i%2 !=0 || i==0){
                int multipliedValue = numberValue * multiplier;
                sum += multipliedValue;
            }
            else if(i !=0&&i%2==0){
                sum+=numberValue;
            }

             }
             int modulus = sum % 10;
             int subtractedMod = 10 - modulus;
        
        return barcodePrefix+subtractedMod;
    }