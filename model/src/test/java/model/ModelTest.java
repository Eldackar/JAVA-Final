package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {

    Model model;

    @Before
    public void setUp() throws Exception {
        this.model = new Model();
    }


    @Test
    public void loadLevel() throws Exception {
        this.model.loadLevel(1);
        assertNotNull(this.model.getLevel());
    }

    @Test
    public void saveLevel() throws Exception {

    }

    @Test
    public void getObservable() throws Exception {
        this.model.loadLevel(1);
        assertNotNull(this.model.getObservable());
    }

}