package in.htlabs.tapas.buthaina.fatma.ictplan;

/**
 * Created by tap on 12/12/2015.
 */
public class TeacherDetails {
    private String teacherId;
    private String teacherName;

    public TeacherDetails(){}

    public TeacherDetails(String teacherId,String teacherName){
        this.teacherId=teacherId;
        this.teacherName=teacherName;
    }
    public void setTeacherId(String teacherId){
        this.teacherId=teacherId;
    }
    public String getTeacherId(){
        return this.teacherId;
    }
    public void setTeacherName(String teacherName){
        this.teacherName=teacherName;
    }
    public String getTeacherName(){
        return this.teacherName;
    }
}