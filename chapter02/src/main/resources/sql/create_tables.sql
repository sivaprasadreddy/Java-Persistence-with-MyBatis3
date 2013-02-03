

CREATE TABLE addresses (
  addr_id int(11) NOT NULL AUTO_INCREMENT,
  street varchar(50) NOT NULL,
  city varchar(50) NOT NULL,
  state varchar(50) NOT NULL,
  zip varchar(10) DEFAULT NULL,
  country varchar(50) NOT NULL,
  PRIMARY KEY (addr_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE tutors (
  tutor_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  email varchar(50) DEFAULT NULL,
  addr_id int(11) DEFAULT NULL,
  PRIMARY KEY (tutor_id),
  CONSTRAINT FK_tutors_addr FOREIGN KEY (addr_id) REFERENCES addresses (addr_id)  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE courses (
  course_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  description varchar(512) DEFAULT NULL,
  start_date date DEFAULT NULL,
  end_date date DEFAULT NULL,
  tutor_id int(11) NOT NULL,
  PRIMARY KEY (course_id),
  CONSTRAINT FK_course_tutor FOREIGN KEY (tutor_id) REFERENCES tutors (tutor_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE students (
  stud_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  addr_id int(11) DEFAULT NULL,
  dob date DEFAULT NULL,
  PRIMARY KEY (stud_id),
  CONSTRAINT FK_students_addr FOREIGN KEY (addr_id) REFERENCES addresses (addr_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE enrollments (
  course_id int(11) NOT NULL,
  stud_id int(11) NOT NULL,
  PRIMARY KEY (course_id,stud_id),
  CONSTRAINT FK_enrollment_stud FOREIGN KEY (stud_id) REFERENCES students (stud_id),
  CONSTRAINT FK_enrollment_course FOREIGN KEY (course_id) REFERENCES courses (course_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;





