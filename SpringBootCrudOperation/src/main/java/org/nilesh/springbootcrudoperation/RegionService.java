package org.nilesh.springbootcrudoperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class RegionService {
	@Autowired
    private RegionDao repository;
    
    public Regions createRegions(Regions regions) {
        return repository.save(regions);
    }
    public List<Regions> listOfRegions() {
        return repository.findAll();
    }
}
