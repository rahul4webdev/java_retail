package org.hotel.app.dto;
import java.sql.Date;
import java.sql.Time;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "billmas")
public class BillMas
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@CreationTimestamp
	private Date entrydate;
	@CreationTimestamp
	private Time entrytime;
	private Date bldate;
	@Column(nullable = false)
	private long guestmob;
	@Column(nullable = false)
	private String guestname;
	private Date checkindate;
	private Date checkoutdate;
	@Column(nullable = false)
	private String guestadd1;
	private String guestadd2;
	private String guestdocno;
	private String guestdocnopath;
	private String guestemail;
	private String guestgstno;
	private String guestcompanyname;
	private String guestroomname;
	private long gueststaydays;
	private long discountperc;
	private long discountpercamt;
	private long adddiscountamt;
	private long additionalcharge;
	private long advanceamount;
	private String blpaidby;
	private String blremarks;
	private long bltotaldays;
	private long bltotal;
	private long blroomrent;
	private long blgstperc;
	private long blgstamt;
	private long blamt;
	private long netpayamt;
	private double checkinid;
	private double roomserviceamt;
	private String roomdescription;
	private String roomdescriptioncode;
	@Column(nullable = false)
	private int status;
	@Column(nullable = false)
    private long shopid;
    @Column(nullable = false)
    private long shopvno;
    @Column(nullable = false)
    private String narration;
    @Column(nullable = false)
    private long acccode;
}
