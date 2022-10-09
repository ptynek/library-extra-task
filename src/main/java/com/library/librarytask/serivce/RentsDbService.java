package com.library.librarytask.serivce;

import com.library.librarytask.domain.Rents;
import com.library.librarytask.exceptions.RentsException;
import com.library.librarytask.repository.RentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentsDbService {

    private final RentsRepository repository;

    public List<Rents> getAllRents(){
        return repository.findAll();
    }

    public Rents getRents(final long rentsId) throws RentsException {
        return repository.findById(rentsId).orElseThrow(RentsException::new);
    }

    public Rents saveRent(final Rents rents){
        return repository.save(rents);
    }


}
