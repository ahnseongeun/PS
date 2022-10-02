package JAVA.java.throws_;

public class test97
{
    private static class FuelException extends Exception {}
    private static class BreakException extends Exception {}

    private static class RepairException extends Exception {}


    private static class Car {
        int fuel = 3;

        //	하나의 함수에서 두개 이상의 예외를 발생 시킬 수 있다.
        //	그 사실은 선언부에 아래와 같이 명시할 수 있다.
        //	함수 호출시 명시된 모든 예외를 처리할 수 있는 try catch 안에서 호출해야 함

        void drive( boolean b ) throws FuelException, BreakException {
            if( b == false ) { throw new BreakException(); }
            if( fuel == 0 ) {
                throw new FuelException();
            }
            System.out.println("10KM GOGO");
            fuel--;
        }
    }

    public static void main(String[] args) {
        Car tico = new Car();
        try {
            try {
                tico.drive( true );
                tico.drive( true );
                tico.drive( true );

                //	아래 상황에 맞게 돌아가는 걸 찍어낼 수 있음 된다.
                //
                //tico.drive( true );
                tico.drive( false );
            }
            catch( FuelException e ) {
                System.out.println("mango!!! " + e.toString() );
            }
            catch( BreakException e ) {
                if( tico.fuel == 0 ) {
                    //	에러를 처리하러 왔는데 감당안된다. 그럼 또 발생시킨다.
                    throw new RepairException();
                }
                System.out.println("tomato!!! " + e.toString() );
            }
            finally {	//	에러가 발생하건 안하건 무조건 수행한다.
                System.out.println("banana!!!");
            }
            System.out.println("Goal!!!");
        }
        catch ( RepairException e ) {
            System.out.println("공장에서 뚝딱");
        }
    }
}
