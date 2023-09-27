static String completeBarcode(String barcodePrefix){
        for(int i = 0; i<barcodePrefix.length();i++){ //Characters are not digits
            if(!Character.isDigit(barcodePrefix.charAt(i))){
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


                                                                //Start of checkdigit

            int evenodd = 0;
            int partsum = 0;

            for(char ch: reversebarcode.toCharArray()){         //This section to calculate the checkdigit
                int currentnum = Character.getNumericValue(ch);
                if(evenodd % 2==0){
                    partsum += currentnum*3; //temp variable
                    evenodd +=1;
                }
                else{ //odd alternate
                    partsum += currentnum*1;
                    evenodd +=1;
                }
                
            }
            int checkdigit = 10-(partsum % 10);
            String check = Integer.toString(checkdigit);
            String newBarcode = barcodePrefix + check;
            return newBarcode;
        }
    }
