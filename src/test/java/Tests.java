import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tests {

@DataProvider
public Object [][] dataPos(){
    return new Object[][]{
            {2,2,4,'+'},
            {2,3,6,'*'},
            {2,1,1,'-'},
            {4,2,2,'/'},
            {0,0,0,'+'},
            {0,0,0,'*'},
            {0,0,0,'-'},
            {0,1,0,'/'},
            {1,0,1,'+'},
            {-1,-1,1,'*'},
            {2,2,0,'-'},
            {1,1,1,'/'},
            {-1,0,-1,'+'},
            {10,0,0,'*'},
            {-20,20,-40,'-'},
            {5,10,0,'/'}
    };
    }

    @DataProvider
    public Object [][] dataNegative(){
        return new Object[][]{
                {"we",2,'/'},
                {4,"2u",'/'},
                {2,"wef",'*'},
                {'*','*','*'},
                {4,2,"dsfdf"},
                {4,"sad",'/'},
        };
    }

    @Test(dataProvider = "dataPos")
    public void testPos(int a, int b,int c, char action){
        Assert.assertEquals(c,new Calc().doAction(action,a,b),"Не верно");
    }


    @Test(dataProvider = "dataNegative",expectedExceptions = ClassCastException.class)
    public void testNegative(Object a, Object b, Object action) {
       Assert.assertFalse((Boolean) new Calc().doAction(action, a, b));
    }
}
