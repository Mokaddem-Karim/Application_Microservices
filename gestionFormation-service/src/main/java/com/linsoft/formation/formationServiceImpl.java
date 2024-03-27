package com.linsoft.formation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class formationServiceImpl implements formationServiceInt {

    @Autowired
    private formationRepo fr;


    @Override
    public formation ajouterFormation(formation f) {

        return fr.save(f);
    }

    @Override
    public Optional<formation> getFormationById(int id) {
        return fr.findById(id);
    }

    @Override
    public List<formation> getAllFormation() {
        return fr.findAll();
    }

    @Override
    public String supprimerFormation(int id) {
        fr.deleteById(id);
        return "suppression avec succée";
    }

    @Override
    public formation modifierFormation(formation f, int id) {
        return   fr.findById(id).map(r -> {
            r.setLib(f.getLib());
            r.setImgSrc(f.getImgSrc());
            r.setDateD(f.getDateD());
            r.setDateF(f.getDateF());
            r.setDureeJ(f.getDureeJ());
            r.setType(f.getType());
            r.setLieu(f.getLieu());
            r.setSpecialite(f.getSpecialite());
            r.setFormateurNP(f.getFormateurNP());
            r.setFormateurMatricule(f.getFormateurMatricule());
            return fr.save(r);
        }).orElseThrow(() -> new RuntimeException("formation inexistante !"));

    }

    //fonction qui parcours tout les formation et si end date of formation == currentSysDate alors disponible=false
    @Override
    public String verifDisponibilite() {
        String currentDate= LocalDate.now().toString();
        System.out.println(currentDate);
        int x=0;
        formation f=null;
        ArrayList<formation> lf=new ArrayList<>();
        lf= (ArrayList<formation>) fr.findAll();
        for(int i=0;i<lf.size();i++){
            LocalDate d= LocalDate.parse(lf.get(i).getDateF(), DateTimeFormatter.ISO_DATE);
           // System.out.println(lf.get(i).getLib()+"--"+"d is after: "+d.isAfter(LocalDate.now()));
            if(d.isEqual(LocalDate.now())||d.isBefore(LocalDate.now())){
                System.out.println("yes is became invailable"+lf.get(i).getLib());
                f=lf.get(i);
                fr.findById(f.getId()).map(r -> {
                    r.setDisponible(false);
                    return fr.save(r);
                });
                x++;
            }

        }
        return x+" formation modifier";

    }


}