package entity;

import java.io.Serializable;
import java.util.List;
//实现serializable接口 就是告诉JVM虚拟机此类可被序列化
// 序列化就是将对象状态转换为可保存或传输的格式的过程
public class PageResult implements Serializable{
    private long total;//总记录数
    private List rows;//当前页

    public PageResult(long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
