package com.solusgames.map;

import java.util.ArrayList;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Class to combine TiledMap and OrthogonalTiledMapRenderer. Also creates an
 * ArrayList of Polygons to use with collision checks.
 * 
 * @author Jan-Niklas
 * 
 */
public class Map {

    private OrthogonalTiledMapRenderer map_renderer;
    private TiledMap map;
    private ArrayList<float[]> col_map;
    private int map_rows;
    private int map_columns;
    private float map_tileHeight;
    private float map_tileWidth;

    public Map(String mapName) {
	createMap(mapName);
    }

    /**
     * Initialize variables and create the map with collision polygons
     */
    private void createMap(String mapName) {

	col_map = new ArrayList<>();
	map = new TmxMapLoader().load("assets/data/map/map_test/" + mapName);
	map_renderer = new OrthogonalTiledMapRenderer(map, 1);

	TiledMapTileLayer l = (TiledMapTileLayer) map.getLayers().get(0);
	map_columns = l.getHeight();
	map_rows = l.getWidth();
	map_tileHeight = l.getTileHeight();
	map_tileWidth = l.getTileWidth();

	for (int i = 0; i < map_rows; i++) {
	    for (int e = 0; e < map_columns; e++) {
		if (l.getCell(i, e) != null) {
		    if (l.getCell(i, e).getTile().getProperties()
			    .containsKey("half")) {
			float[] list = new float[8];
			list[0] = i * map_tileWidth + 0;
			list[1] = e * map_tileHeight + 0;
			list[2] = i * map_tileWidth + 0;
			list[3] = e * map_tileHeight + map_tileHeight / 2;
			list[4] = i * map_tileWidth + map_tileWidth;
			list[5] = e * map_tileHeight + 0;
			list[6] = i * map_tileWidth + map_tileWidth;
			list[7] = e * map_tileHeight + map_tileHeight / 2;
			col_map.add(list);
		    }
		    if (l.getCell(i, e).getTile().getProperties()
			    .containsKey("full")) {
			float[] list = new float[8];
			list[0] = i * map_tileWidth + 0;
			list[1] = e * map_tileHeight + 0;
			list[2] = i * map_tileWidth + 0;
			list[3] = e * map_tileHeight + map_tileHeight;
			list[4] = i * map_tileWidth + map_tileWidth;
			list[5] = e * map_tileHeight + 0;
			list[6] = i * map_tileWidth + map_tileWidth;
			list[7] = e * map_tileHeight + map_tileHeight;

			col_map.add(list);
		    }
		    if (l.getCell(i, e).getTile().getProperties()
			    .containsKey("triangle_l")) {
			float[] list = new float[8];
			list[0] = i * map_tileWidth + 0;
			list[1] = e * map_tileHeight + 0;
			list[2] = i * map_tileWidth + map_tileWidth;
			list[3] = e * map_tileHeight + 0;
			list[4] = i * map_tileWidth + 0;
			list[5] = e * map_tileHeight + map_tileHeight;
			list[6] = i * map_tileWidth + 0;
			list[7] = e * map_tileHeight + map_tileHeight;

			col_map.add(list);
		    }
		    if (l.getCell(i, e).getTile().getProperties()
			    .containsKey("triangle_r")) {
			float[] list = new float[8];
			list[0] = i * map_tileWidth + 0;
			list[1] = e * map_tileHeight + 0;
			list[2] = i * map_tileWidth + map_tileWidth;
			list[3] = e * map_tileHeight + 0;
			list[4] = i * map_tileWidth + map_tileWidth;
			list[5] = e * map_tileHeight + map_tileHeight;
			list[6] = i * map_tileWidth + map_tileWidth;
			list[7] = e * map_tileHeight + map_tileHeight;

			col_map.add(list);
		    }
		}
	    }
	}
    }

    public void dispose() {
	map_renderer.dispose();

    }

    /**
     * @return the map_renderer
     */
    public OrthogonalTiledMapRenderer getMap_renderer() {
	return map_renderer;
    }

    /**
     * @param map_renderer
     *            the map_renderer to set
     */
    public void setMap_renderer(OrthogonalTiledMapRenderer map_renderer) {
	this.map_renderer = map_renderer;
    }

    /**
     * @return the map
     */
    public TiledMap getMap() {
	return map;
    }

    /**
     * @param map
     *            the map to set
     */
    public void setMap(TiledMap map) {
	this.map = map;
    }

    /**
     * @return the col_map
     */
    public ArrayList<float[]> getCol_map() {
	return col_map;
    }

    /**
     * @param col_map
     *            the col_map to set
     */
    public void setCol_map(ArrayList<float[]> col_map) {
	this.col_map = col_map;
    }

    /**
     * @return the map_rows
     */
    public int getMap_rows() {
	return map_rows;
    }

    /**
     * @param map_rows
     *            the map_rows to set
     */
    public void setMap_rows(int map_rows) {
	this.map_rows = map_rows;
    }

    /**
     * @return the map_columns
     */
    public int getMap_columns() {
	return map_columns;
    }

    /**
     * @param map_columns
     *            the map_columns to set
     */
    public void setMap_columns(int map_columns) {
	this.map_columns = map_columns;
    }

    /**
     * @return the map_tileHeight
     */
    public float getMap_tileHeight() {
	return map_tileHeight;
    }

    /**
     * @param map_tileHeight
     *            the map_tileHeight to set
     */
    public void setMap_tileHeight(float map_tileHeight) {
	this.map_tileHeight = map_tileHeight;
    }

    /**
     * @return the map_tileWidth
     */
    public float getMap_tileWidth() {
	return map_tileWidth;
    }

    /**
     * @param map_tileWidth
     *            the map_tileWidth to set
     */
    public void setMap_tileWidth(float map_tileWidth) {
	this.map_tileWidth = map_tileWidth;
    }

}
