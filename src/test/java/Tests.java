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
    public Object [][] dataNegativeEquals(){
        return new Object[][]{
                {2,2,5,'+'},
                {2,3,10,'*'},
                {2,1,0,'-'},
                {4,2,1,'/'},
        };

    }@DataProvider
    public Object [][] dataNegative(){
        return new Object[][]{
                {"we",2,1,'/'},
                {4,"2u",1,'/'},
                {2,"wef",10,'*'},
                {'*','*','*','*'},
                {4,2,1,"dsfdf"},
                {4,"sad",-1,'/'},
        };
    }

    @Test(dataProvider = "dataPos")
    public void testPos(int a, int b,int c, char action){
        Assert.assertEquals(c,new Calc().doAction(action,a,b),"Не верно");
    }


    @Test(dataProvider = "dataNegativeEquals")
    public void testNegativeEquals(Object a, Object b,Object c, Object action){
        Assert.assertNotEquals(c,new Calc().doAction(action,a,b),"Не верно");
    }

    @Test(dataProvider = "dataNegative")
    public void testNegative(Object a, Object b,Object c, Object action) {
    try {
        Assert.assertFalse((boolean) new Calc().doAction(action, a, b), "Не верно");
    }catch (ClassCastException e){
            System.out.println("ClassCastException Test");
        }
    }
}
