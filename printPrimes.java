static void printPrimes(int max){
        for(int i = 2; i<=max;i++){
            boolean Prime = true;
            for(int f = 2; f<=i/2;f++){
                if(i%f==0){
                    Prime = false;
                }
            }
            if(Prime){
                System.out.println(i);
            }
        }
    }
