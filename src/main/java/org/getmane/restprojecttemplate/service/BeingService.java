package org.getmane.restprojecttemplate.service;

import org.getmane.restprojecttemplate.domain.Being;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BeingService {

    private final List<Being> beings;

    public BeingService(List<Being> beings) {
        this.beings = beings;
    }

    public List<Being> findAll() {
        return beings;
    }

    public Being findById(Long id) {
        return beings.stream().filter(being -> being.getId().equals(id)).findFirst().orElseThrow(
                () -> new NoSuchElementException("Nothing found by id " + id)
        );
    }

    public Being save(Being being) {
        for (int i = 0; i < beings.size(); i++) {
            if (beings.get(i).getId().equals(being.getId())) {
                beings.set(i, being);
                return being;
            }
        }
        being.setId((long) beings.size());
        beings.add(being);
        return being;
    }

    public Being updateById(Long id, Being being) {
        Being existingBeing = findById(id);

        existingBeing.setName(being.getName());
        existingBeing.setNicknames(being.getNicknames());

        return save(existingBeing);
    }

    public Being deleteById(Long id) {
        Being existingBeing = findById(id);

        beings.remove(existingBeing);

        return existingBeing;
    }
}
