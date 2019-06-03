package view;

import org.junit.After;
import org.junit.Before;

import java.lang.reflect.Field;

public class ViewPanelTest {

	private ViewPanel ViewPanel;
    private Field[] fields;

    /** SetUp the junit tests of ViewPanel class. */
    @Before
    public void setUp(){
        this.ViewPanel = new ViewPanel();

        Class<?> modelReflector = this.ViewPanel.getClass();
        this.fields = modelReflector.getDeclaredFields();
        for(Field field : this.fields) {
            field.setAccessible(true);
        }
    }

    @After
    public void tearDown() throws Exception{
    }
}
