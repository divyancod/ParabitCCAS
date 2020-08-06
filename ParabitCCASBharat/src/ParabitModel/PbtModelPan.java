package ParabitModel;


public class PbtModelPan{

  private String adhrNo;
  private String panNo;
  private String srcOInc;

    public PbtModelPan(String adhrNo, String panNo, String srcOInc) {
        this.adhrNo = adhrNo;
        this.panNo = panNo;
        this.srcOInc = srcOInc;
    }


  public String getAdhrNo() {
    return adhrNo;
  }

  public void setAdhrNo(String adhrNo) {
    this.adhrNo = adhrNo;
  }


  public String getPanNo() {
    return panNo;
  }

  public void setPanNo(String panNo) {
    this.panNo = panNo;
  }


  public String getSrcOInc() {
    return srcOInc;
  }

  public void setSrcOInc(String srcOInc) {
    this.srcOInc = srcOInc;
  }

}
