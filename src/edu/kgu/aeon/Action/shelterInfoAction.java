package edu.kgu.aeon.Action;

import edu.kgu.aeon.bean.shelterInfoBean;
import edu.kgu.aeon.logic.shelterInfoLogic;
import edu.kgu.log.LogLogger;

public class shelterInfoAction extends BaseAction {
	// logic
		shelterInfoLogic logic = new shelterInfoLogic();

		// request param
		private String lat = "";
		private String lng = "";
		private String placeName = "";
		private String fid = "";
		private String address = "";
		private String tel = "";
		private String comment = "";

		public String getLat() {
			return lat;
		}

		public void setLat(String lat) {
			this.lat = lat;
		}

		public String getLng() {
			return lng;
		}

		public void setLng(String lng) {
			this.lng = lng;
		}

		public String getPlaceName() {
			return placeName;
		}

		public void setPlaceName(String placeName) {
			this.placeName = placeName;
		}

		public String getFid() {
			return fid;
		}

		public void setFid(String fid) {
			this.fid = fid;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		// return value
		private String result;
		
		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}
		
		// execute
		public String execute() {
			try {
				placeName = new String(placeName.getBytes("ISO-8859-1"),"utf-8");
				address = new String(address.getBytes("ISO-8859-1"),"utf-8");
				comment = new String(comment.getBytes("ISO-8859-1"),"utf-8");
				
//				LogLogger.info(placeName);
				
				shelterInfoBean bean = new shelterInfoBean();
				
				bean.setUserID(this.getUserID());
				bean.setLat(lat);
				bean.setLng(lng);
				bean.setPlaceName(placeName);
				bean.setFid(fid);
				bean.setAddress(address);
				bean.setTel(tel);
				bean.setComment(comment);
				
				logic.execute(bean);
				
				this.result = "{0}";
			} catch(Exception e) {
				this.result = "{1}";
				LogLogger.error(e);
			}
			
			return SUCCESS;		 
		}
}
