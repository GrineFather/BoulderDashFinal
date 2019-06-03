package view;

import contract.IModel;
import org.junit.*;

import java.lang.reflect.Field;
import java.util.Observable;

public class ViewFrameTest {

	protected ViewFrame ViewFrame;
    protected IModel Model;

    private Field[] fields;

    /** SetUp the junit tests of ViewFrame class. */
    @Before
    public void setUp() throws Exception{
        this.Model = new IModel(){
            
            @Override
            public boolean isWin() {
                return false;
            }
            @Override
            public boolean getIsAlivePlayer() {
                return false;
            }
            @Override
            public int[] getPositionsPlayer() {
                return new int[0];
            }
            @Override
            public void setMovePlayer(int x, int y) throws Exception {}
            
            @Override
            public char[][] convertMap() {
                return new char[0][];
            }
            @Override
            public Observable getObservable() {
                return null;
            }
            @Override
            public boolean getIsOpenExit() {
                return false;
            }
        };

        this.ViewFrame = new ViewFrame(Model);

        Class<?> modelReflector = this.ViewFrame.getClass();
        this.fields = modelReflector.getDeclaredFields();
        for(Field field : this.fields) {
            field.setAccessible(true);
        }
    }

    @After
    public void tearDown() throws Exception {
    	
    }
}
