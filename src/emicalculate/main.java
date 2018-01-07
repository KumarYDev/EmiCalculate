package emicalculate;

public class main {
    double amount=2537196;
    double rate=13.75;
    int months =90;
    double emi;
    int payment=1700*60;
    boolean status=true;


    String result;
    public static void main(String[] args){
        int i=0,p=20;
        Double emi;
        main main=new main();

        main.getvalues(main.amount,main.rate,main.months);

        while(main.amount>=main.payment){
            i++;
            System.out.print("Payment\t"+i+"\t");


            main.paid(main.payment,main);

            System.out.print("\n");
            p--;
        }

    }


//    (amount, rate of intreset, no of months)


    public double getvalues(double a, Double r, int m) {

//        Formula =[P x R x (1+R)^N]/[(1+R)^N-1]  rateper month= rate/1200

//        double emi;
        double intmth=(a*r)
                /1200;
        Double rm=r/1200;
//        System.out.print("Model DATA "+String.valueOf(intmth));

//        emi=(intmth*Math.pow(1+(intmth/a),m))/(Math.pow(1+(intmth/a),m-1));
        emi=(a*rm*Math.pow(1+rm,m))/(Math.pow(1+rm,m)-1);
//        System.out.print("\nModel DATA "+intmth                +"\n"+emi);
//        System.out.print("\nIntrest per month= "+Math.round(intmth)
//
//                +"\t"+"EMI="+Math.round(emi));
return emi;
    }

    public void paid(int amount,main main){
        double paid;
        double intmth=(main.amount*main.rate)/1200;
           paid=amount-intmth;

        emi= main.getvalues(main.amount,main.rate,main.months);
        if(main.amount<=main.payment) {
            main.status = false;


            System.out.print("Amount paid: " + main.amount
                    + "\t" + "Amount Left: " + 0
                    + "\t" + "EMI:" + 0);

        }else {

            update(main, paid);
            System.out.print("Amount paid: " + Math.round(paid)
                    + "\t" + "Amount Left: " + Math.round(main.amount - paid)
                    + "\t" + "EMI:" + Math.round(emi));
        }

    }

    public void update(main main,double amt){
        main.amount=main.amount-amt;
        main.months--;

    }
}
