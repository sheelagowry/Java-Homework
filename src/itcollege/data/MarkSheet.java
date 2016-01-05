package itcollege.data;

import java.util.ArrayList;

public class MarkSheet {
 public String exmId;
 public int stdId;
 public ArrayList<Mark> marks;
 
 public int getMark(String code) {
		for(Mark o : marks)
		{
			if(o.code == code){
				return o.mark;
			}
		}
		return 0;
 }
 
}
