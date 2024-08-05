package org.hotel.app.dto;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "shopmas")
public class ShopMas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private Date startdate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastbilldate;

    @Column(unique = true, nullable = false)
    private String email;
    
    private String password;

    @Column(nullable = false)
    private String cname;

    private String address;
    
    private String billprintline1;
    private String billprintline2;
    private String billprintline3;
    private String billprintline4;
    private String billprintline5;
    
    private String billprintlineTC1;
    private String billprintlineTC2;
    private String billprintlineTC3;
    private String billprintlineTC4;
    private String billprintlineTC5;
    
    @Column(nullable = false)
    private long restservicechperc;
    @Column(nullable = false)
    private long restdlvchperc;
    @Column(nullable = false)
    private long restdlvchamt;

    private String gstno;

    private long pincode;

    @Column(nullable = false)
    private long showtaxsummary;
    
    @Column(nullable = false)
    private long gsttype;
    
    
    @Column(nullable = false)
    private long mobno;

    @Column(nullable = false)
    private long gst5;

    @Column(nullable = false)
    private long gst12;

    @Column(nullable = false)
    private long gst18;

    @Column(nullable = false)
    private long gst28;

    @Column(nullable = false)
    private long changecheckoutdate;
    
    @Column(nullable = false)
    private long print_hidekotno;
    
    @Column(nullable = false)
    private long fs_kottype;
    @Column(nullable = false)
    private long fs_kotno;
    
    @Column(nullable = false)
    private long itwashow;

    @Column(nullable = false)
    private long dcotont; //// Delivery Charge on Taxable or non taxable

    
    public ShopMas() {
        this.gst5 = 1000;
        this.gst12 = 2000;
        this.gst18 = 3000;
        this.gst28 = 4000;
        this.fs_kotno = 18;
        this.fs_kottype = 18;
        

        Date currentDate = new Date();
        long currentTimeInMillis = currentDate.getTime();
        long tenDaysInMillis = 10 * 24 * 60 * 60 * 1000; // 10 days in milliseconds
        long lastBillTimeInMillis = currentTimeInMillis + tenDaysInMillis;
        this.lastbilldate = new Date(lastBillTimeInMillis);
    }
}
