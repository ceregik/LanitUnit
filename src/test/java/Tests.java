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
                {2,2,5,'+'},
                {2,3,10,'*'},
                {2,1,0,'-'},
                {4,2,1,'/'},
                {0,0,-1,'+'},
                {0,0,1,'*'},
                {0,0,5,'-'},
                {0,1,1,'/'},
                {1,0,0,'+'},
                {-1,-1,-1,'*'},
                {2,2,2,'-'},
                {1,1,0,'/'},
                {-1,0,1,'+'},
                {10,0,10,'*'},
                {-20,20,0,'-'},
                {5,10,1,'/'}
        };
    }

    @Test(dataProvider = "dataPos")
    public void testPos(int a, int b,int c, char action){
        Assert.assertEquals(c,new Calc().doAction(action,a,b),"Не верно");
    }


    @Test(dataProvider = "dataNegative")
    public void testNegative(int a, int b,int c, char action){
        Assert.assertNotEquals(c,new Calc().doAction(action,a,b),"Не верно");
    }
}
