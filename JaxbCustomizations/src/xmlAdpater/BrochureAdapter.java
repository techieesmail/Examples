/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlAdpater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Family
 */
//public class BrochureAdapter extends XmlAdapter<ArrayList<Course>, HashMap<String,Course>> {
//
//    @Override
//    public HashMap<String, Course> unmarshal(ArrayList<Course> v) throws Exception {
//        
//        Iterator<Course> iter = v.iterator();
//        HashMap<String, Course> map = new HashMap<String, Course>();
//        while(iter.hasNext())
//        {
//            Course c = iter.next();
//            map.put(c.getId(), c);
//            
//        }
//        return map;
//    }
//
//    @Override
//    public ArrayList<Course> marshal(HashMap<String, Course> v) throws Exception {
//       
//        Set<String> keySet = v.keySet();
//        Iterator<String> keyIter = keySet.iterator();
//        System.out.println("The iter size "+keySet.size());
//        ArrayList<Course> ls = new ArrayList<Course>();
//        while(keyIter.hasNext())
//        {
//            Course c = v.get(keyIter.next());
//            System.out.println("The id is "+c.getPrice());
//            ls.add(c);
//            
//        }
//        System.out.println("The length is "+ls.size());
//        return ls;
//    }
    
    
    
//    public class BrochureAdapter extends XmlAdapter<ListCourse, HashMap<String,Course>> {
//
//    @Override
//    public HashMap<String, Course> unmarshal(ListCourse v) throws Exception {
//        
//        Iterator<Course> iter = v.ls.iterator();
//        HashMap<String, Course> map = new HashMap<String, Course>();
//        while(iter.hasNext())
//        {
//            Course c = iter.next();
//            map.put(c.getId(), c);
//            
//        }
//        return map;
//    }
//
//    @Override
//    public ListCourse marshal(HashMap<String, Course> v) throws Exception {
//       
//        Set<String> keySet = v.keySet();
//        Iterator<String> keyIter = keySet.iterator();
//        System.out.println("The iter size "+keySet.size());
//        ListCourse lc = new ListCourse();
//        List<Course> ls = lc.ls;
//        while(keyIter.hasNext())
//        {
//            Course c = v.get(keyIter.next());
//            System.out.println("The id is "+c.getPrice());
//            ls.add(c);
//            
//        }
//        System.out.println("The length is "+ls.size());
//        return lc;
//    }
    
    
    
    public class BrochureAdapter extends XmlAdapter<ListCourse, Brochure> {

    @Override
    public Brochure unmarshal(ListCourse v) throws Exception {
        System.out.println("The size  in unmarshall is "+v.ls.iterator());
        //Iterator<Course> iter = v.getLs().iterator();
         Iterator<Course> iter = v.ls.iterator();
        HashMap<String, Course> map = new HashMap<String, Course>();
        Brochure b = new Brochure();
        while(iter.hasNext())
        {
            Course c = iter.next();
            System.out.println("The id is "+c.getId());
            map.put(c.getId(), c);
            
        }
        b.setCourses(map);
        return b;
    }

    @Override
    public ListCourse marshal(Brochure b) throws Exception {
       
        HashMap<String,Course> v = b.getCourses();
        Set<String> keySet = v.keySet();
        Iterator<String> keyIter = keySet.iterator();
        System.out.println("The brochure id is "+b.getId());
        
        System.out.println("The iter size "+keySet.size());
        ListCourse lc = new ListCourse();
        lc.id = b.getId();
        List<Course> ls = lc.ls;
//         List<Course> ls = lc.getLs();
        while(keyIter.hasNext())
        {
            Course c = v.get(keyIter.next());
            System.out.println("The id is "+c.getPrice());
            ls.add(c);
            
        }
        System.out.println("The length is "+ls.size());
        return lc;
    }
    
    
    
    
//    public class BrochureAdapter extends XmlAdapter<Course, HashMap<String,Course>> {
//
//    @Override
//    public HashMap<String, Course> unmarshal(Course v) throws Exception {
//        
//        
//        HashMap<String, Course> map = new HashMap<String, Course>();
//      
//            Course c = v;
//            map.put(c.getId(), c);
//            
//     
//        return map;
//    }
//
//    @Override
//    public Course marshal(HashMap<String, Course> v) throws Exception {
//       
//        Set<String> keySet = v.keySet();
//        Iterator<String> keyIter = keySet.iterator();
//        System.out.println("The iter size "+keySet.size());
////        ArrayList<Course> ls = new ArrayList<Course>();
//        Course c = null;
//        while(keyIter.hasNext())
//        {
//             c = v.get(keyIter.next());
//            System.out.println("The id is "+c.getPrice());
////            ls.add(c);
//            //return c;
////            
//        }
//        return c;
////        System.out.println("The length is "+ls.size());
//        
//    }
    
    
   
}
