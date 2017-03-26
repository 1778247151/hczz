package com.crm.pojo;

import java.io.Serializable;
import java.util.List;

import com.crm.pojo.GwMenuTreeModel;

public class GwMenuTreeModel implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5509689754450196908L;

	private Integer id;

    private String name;

    private String note;

    private String urladdress;

    private Integer fid;

    private String state;

    private String time;

    private Integer orderNum;
    
    private String type;
    
    private String icon;
    
    private String func;
    
    private String style;
    
    /**
     * 是否同步数据功能（0-否【不同步数据】，1-是【同步数据】），默认为0
     */
    private Integer synchronize;
    
    private List<GwMenuTreeModel> childList;
    
    

    public List<GwMenuTreeModel> getChildList() {
		return childList;
	}

	public void setChildList(List<GwMenuTreeModel> childList) {
		this.childList = childList;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getUrladdress() {
        return urladdress;
    }

    public void setUrladdress(String urladdress) {
        this.urladdress = urladdress == null ? null : urladdress.trim();
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getTime() {
        return time;
    }
    

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

    public Integer getSynchronize() {
        return synchronize;
    }

    public void setSynchronize(Integer synchronize) {
        this.synchronize = synchronize;
    }

	@Override
	public String toString() {
		return "GwMenuTreeModel [id=" + id + ", name=" + name + ", note=" + note + ", urladdress=" + urladdress
				+ ", fid=" + fid + ", state=" + state + ", time=" + time + ", orderNum=" + orderNum + ", type=" + type
				+ ", icon=" + icon + ", func=" + func + ", style=" + style + ", synchronize=" + synchronize
				+ ", childList=" + childList + "]";
	}
	
    
}