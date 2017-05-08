package com.library.data.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Entity
@Table(name="AUTHORS")*/
@Embeddable
public class Authors {
	 
		@Column(name="EMAIL_ID")
		private String email_id;
		
		@Column(name="AUTHOR_NAME")
		private String author_name;

		public String getEmail_id() {
			return email_id;
		}

		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}

		public String getAuthor_name() {
			return author_name;
		}

		public void setAuthor_name(String author_name) {
			this.author_name = author_name;
		}
		
				
}
