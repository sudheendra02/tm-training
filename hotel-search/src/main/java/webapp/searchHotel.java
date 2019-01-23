package webapp;

import java.util.*;

public class searchHotel {
	List<String> filteredhotels = new ArrayList<String>();
	
	void search(String hotel_name,List<String> allhotels)
	{
		for(int i=0;i<allhotels.size();i++)
		{
			int index=0,flag=1;
			for(int j=0;j<hotel_name.length();j++)
			{
				index =allhotels.get(i).indexOf(hotel_name.charAt(j), index);
				if(index==-1)
				{
					flag=0;
					break;
				}
			}
			if(flag==1)
			{
				filteredhotels.add(allhotels.get(i));
			}
			
		}
		
	}
}
