package changeminer.HandlerForUSA;

import java.util.ArrayList;

import com.itplus.cm.ce.addon.common.custom.HandlerForUSA;
import com.itplus.cm.ce.internal.meta.CM_OBJ_DPD;
import com.itplus.cm.ce.internal.meta.CM_SRC;

import extractor.common.tobj.TDpd;

public class DPD_RESULT_OUTER extends HandlerForUSA {
	public DPD_RESULT_OUTER() {
	}

	public boolean generateDPD(String PREFIX, CM_SRC cm_src, CM_OBJ_DPD cm_obj_dpd) {
		return false;
	}
	
    public boolean generateDPD(String PREFIX, CM_SRC cm_src, CM_OBJ_DPD cm_obj_dpd, TDpd usadpd, ArrayList dpd_list) {
    	this.log.trace("##USA ORDER TEST ::", cm_obj_dpd.getDPD_TYPE_ID()+"::"+cm_obj_dpd.getCALL_TARGET()+":"+ usadpd.getGID()+":"+usadpd.getTLocation().getStartLine());
        boolean is_sql = generateDPD(PREFIX, cm_src, cm_obj_dpd, dpd_list);
        return is_sql;
    }
}