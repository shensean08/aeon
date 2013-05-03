package edu.kgu.aeon.agent;

import org.json.*;

import edu.kgu.log.LogLogger;

public class agentJSON {
	private int frameWidth;
	private int frameHeight;
	private int Xcnt;
	private int Ycnt;
	private JSONObject agent = new JSONObject();
	private JSONObject animations = new JSONObject();
	
	public agentJSON(int width,int height,int XCnt, int YCnt)  {
		this.frameWidth = width;
		this.frameHeight = height;
		this.Xcnt = XCnt;
		this.Ycnt = YCnt;
	}
	
	public String getResult() {
		try {
			agent.put("overlayCount", 3);
			agent.put("sounds", this.createSound(33));
			agent.put("framesize", this.createFramesize());
			agent.put("animations", animations);
		} catch (Exception e) {
			LogLogger.error(e);
		}
		return agent.toString();
	}
	
	private JSONArray createSound(int count) {
		JSONArray rtn = new JSONArray();
		for (int i = 0; i < count; i++) {
			rtn.put(String.valueOf(i));
		}
		return rtn;
	}
	
	private JSONArray createFramesize() {
		JSONArray rtn = new JSONArray();
		rtn.put(this.frameWidth);
		rtn.put(this.frameHeight);
		return rtn;
	}
	
	public void addAnimation(String name,int x, int y, int count) {
		JSONObject animation = new JSONObject();
		int xLoc = frameWidth * x;
		int yLoc = frameHeight * y;
		
		try {
			JSONArray frames = new JSONArray();
			int account = 0;
			
			for (int i = 0; i < count; i++) {
				JSONObject frame = new JSONObject();
				JSONArray images = new JSONArray();
				JSONArray image = new JSONArray();
				
				image.put(xLoc);
				image.put(yLoc);
				images.put(image);
				xLoc += this.frameWidth;
				
				frame.put("duration", 100);
				frame.put("images", images);
				frames.put(frame);
				account++;
				
				if (account >= Xcnt) {
					account = 0;
					yLoc += this.frameHeight;
					xLoc = 0;
				}
			}
			
			animation.put("frames", frames);
			this.animations.put(name, animation);
		} catch (Exception e) {
			LogLogger.error(e);
		}	
	}
}
