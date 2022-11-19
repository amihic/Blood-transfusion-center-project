package com.example.ISA;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import com.example.ISA.model.MedCenter;
import com.example.ISA.model.Rating;
import com.example.ISA.repository.MedCenterRepository;
import com.example.ISA.repository.RatingRepository;

@SpringBootApplication//(exclude =  {DataSourceAutoConfiguration.class })
@EnableAsync
public class IsaApplication implements CommandLineRunner{

	@Autowired
	private MedCenterRepository medCenterRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	public static void main(String[] args)  {
		
		SpringApplication.run(IsaApplication.class, args);
	}
	@Override
	public void run(String[] args) throws Exception
    {
		
				
		Rating newRating1 = new Rating(1,10,null);
		Rating newRating2 = new Rating(2,9,null);
        Rating newRating3 = new Rating(3,9,null);
        Rating newRating4 = new Rating(4,8,null);
        Rating newRating5 = new Rating(5,7,null);
        Rating newRating6 = new Rating(6,8,null);
        Rating newRating7 = new Rating(7,9,null);
        Rating newRating8 = new Rating(8,9,null);
        Rating newRating9 = new Rating(9,8,null);
        Rating newRating10 = new Rating(10,6,null);
        

        
	    ratingRepository.save(newRating1);
		ratingRepository.save(newRating2);
        ratingRepository.save(newRating3);
        ratingRepository.save(newRating4);
        ratingRepository.save(newRating5);
        ratingRepository.save(newRating6);
        ratingRepository.save(newRating7);
        ratingRepository.save(newRating8);
        ratingRepository.save(newRating9);
        ratingRepository.save(newRating10);
        
		ArrayList<Rating> rate1 = new ArrayList<>();
		ArrayList<Rating> rate2 = new ArrayList<>();
		ArrayList<Rating> rate3 = new ArrayList<>();
		ArrayList<Rating> rate4 = new ArrayList<>();
		ArrayList<Rating> rate5 = new ArrayList<>();
		rate1.add(newRating1);
		rate1.add(newRating2);
		rate2.add(newRating3);
		rate2.add(newRating4);
		rate3.add(newRating5);
		rate3.add(newRating6);
		rate4.add(newRating7);
		rate4.add(newRating8);
		rate5.add(newRating9);
		rate5.add(newRating10);
		
		
        MedCenter newMedCenter1 = new MedCenter(1, "MedCentarKV", "Jug Bogdanova 33", "Kraljevo", "Srbija", "Medicinski centar za davanje krvi", 0.0, rate1, null, null);
        MedCenter newMedCenter2 = new MedCenter(2, "MedCentarPalilula", "Palilula 27", "Beograd", "Srbija", "Medicinski centar za davanje krvi", 0.0, rate2, null, null);
        MedCenter newMedCenter3 = new MedCenter(3, "MladenovacMC", "Hajduk Veljkova 111", "Mladenovac", "Srbija", "Medicinski centar za davanje krvi", 0.0, rate3, null, null);
        MedCenter newMedCenter4 = new MedCenter(4, "SuboticaMC", "Suboticka 78", "Subotica", "Srbija", "Medicinski centar za davanje krvi", 0.0, rate4, null, null);
        MedCenter newMedCenter5 = new MedCenter(5, "MCKrusevac", "Cara Lazara 56", "Krusevac", "Srbija", "Medicinski centar za davanje krvi", 0.0, rate5, null, null);




        medCenterRepository.save(newMedCenter1);
        medCenterRepository.save(newMedCenter2);
        medCenterRepository.save(newMedCenter3);
        medCenterRepository.save(newMedCenter4);
        medCenterRepository.save(newMedCenter5);
        
    }
}
