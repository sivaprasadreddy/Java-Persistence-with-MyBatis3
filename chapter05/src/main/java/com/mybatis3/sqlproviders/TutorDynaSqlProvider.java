/**
 * 
 */
package com.mybatis3.sqlproviders;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

import java.util.Map;

import com.mybatis3.domain.Tutor;
/**
 * @author Siva
 *
 */
public class TutorDynaSqlProvider 
{

	public String findAllTutorsSql() 
	{
		BEGIN();
		SELECT("tutor_id as tutorId, name, email");
	    FROM("tutors");
	    return SQL();
	}
	
	public String findTutorByIdSql(int tutorId) 
	{
		BEGIN();
		SELECT("tutor_id as tutorId, name, email");
	    FROM("tutors");
	    WHERE("tutor_id="+tutorId);
	    return SQL();
	}
	
	
	public String findTutorByNameAndEmailSql(Map<String, Object> map) 
	{
		//String name = (String) map.get("name");
		//String email = (String) map.get("email");
		//System.err.println(name+":"+email);
		BEGIN();
		SELECT("tutor_id as tutorId, name, email");
	    FROM("tutors");
	    WHERE("name=#{name} AND email=#{email}");
	    return SQL();
	}
	
	public String insertTutor(Tutor tutor) {
		BEGIN();
        INSERT_INTO("TUTORS");
        
        if (tutor.getName() != null) {
            VALUES("NAME", "#{name}");
        }
        
        if (tutor.getEmail() != null) {
            VALUES("EMAIL", "#{email}");
        }
        return SQL();
	}
	
	public String updateTutor(Tutor tutor) 
	{
		BEGIN();
		UPDATE("TUTORS");
        
        if (tutor.getName() != null) {
        	SET("NAME = #{name}");
        }
        
        if (tutor.getEmail() != null) {
        	SET("EMAIL = #{email}");
        }
        WHERE("TUTOR_ID = #{tutorId}");
        return SQL();
	}
	
	public String deleteTutor(int tutorId) 
	{
		BEGIN();
		DELETE_FROM("TUTORS");
        WHERE("TUTOR_ID = #{tutorId}");
        return SQL();
	}
	
	public String selectTutorById() 
	{		
		BEGIN();
		SELECT("t.tutor_id, t.name as tutor_name, email, a.addr_id, street, city, state, zip, country,course_id, c.name as course_name, description, start_date, end_date");
		FROM("TUTORS t");
		LEFT_OUTER_JOIN("addresses a on t.addr_id=a.addr_id");
		LEFT_OUTER_JOIN("courses c on t.tutor_id=c.tutor_id");
        WHERE("t.TUTOR_ID = #{tutorId}");
        return SQL();		
	}
}
