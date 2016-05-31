package com.sebatec.tiles;

import org.apache.tiles.TilesApplicationContext;
import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.startup.AbstractTilesInitializer;
import org.apache.tiles.startup.TilesInitializer;
import org.apache.tiles.web.startup.AbstractTilesListener;



// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving myApacheTiles events.
 * The class that is interested in processing a myApacheTiles
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addMyApacheTilesListener<code> method. When
 * the myApacheTiles event occurs, that object's appropriate
 * method is invoked.
 *
 * @see MyApacheTilesEvent
 */
public class MyApacheTilesListener extends AbstractTilesListener {

	@Override
    protected TilesInitializer createTilesInitializer() {
        return new TestTilesListenerInitializer();
    }

    private static class TestTilesListenerInitializer extends AbstractTilesInitializer {

        @Override
        protected AbstractTilesContainerFactory createContainerFactory(
                TilesApplicationContext context) {
            return new TestTilesContainerFactory();
        }
    }

}
