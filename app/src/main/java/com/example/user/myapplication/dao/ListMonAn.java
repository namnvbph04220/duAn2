package com.example.user.myapplication.dao;

import com.example.user.myapplication.DTO.MonDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 8/4/2017.
 */

public class ListMonAn {
    public List<MonDTO> getDsMonAn(){
        List<MonDTO> monDTOs = new ArrayList<>();
        MonDTO monDTO1 = new MonDTO("Cơm trắng",200);
        monDTOs.add(monDTO1);
        MonDTO monDTO2 = new MonDTO("Bầu xào trứng",109);
        monDTOs.add(monDTO2);
        MonDTO monDTO3 = new MonDTO("Bò bía",93);
        monDTOs.add(monDTO3);
        MonDTO monDTO4 = new MonDTO("Bò cuốn lá lốt",841);
        monDTOs.add(monDTO4);
        MonDTO monDTO5 = new MonDTO("Bò cuốn mỡ chài",1180);
        monDTOs.add(monDTO5);
        MonDTO monDTO6 = new MonDTO("Cá bạc má chiên",135);
        monDTOs.add(monDTO6);
        MonDTO monDTO7 = new MonDTO("Cá bạc má kho",167);
        monDTOs.add(monDTO7);
        MonDTO monDTO8 = new MonDTO("Cá cơm lăn bột chiên",195);
        monDTOs.add(monDTO8);
        MonDTO monDTO9 = new MonDTO("Cá chép chưng tương",156);
        monDTOs.add(monDTO9);
        MonDTO monDTO10 = new MonDTO("Cá chim chiên",111);
        monDTOs.add(monDTO10);
        MonDTO monDTO11 = new MonDTO("Cá đối chiên",108);
        monDTOs.add(monDTO11);
        MonDTO monDTO12 = new MonDTO("Cá đối kho",82);
        monDTOs.add(monDTO12);
        MonDTO monDTO13 = new MonDTO("Cá hú kho",184);
        monDTOs.add(monDTO13);
        MonDTO monDTO14 = new MonDTO("Cá lóc chiên",169);
        monDTOs.add(monDTO14);
        MonDTO monDTO15 = new MonDTO("Cá lóc kho",131);
        monDTOs.add(monDTO15);
        MonDTO monDTO16 = new MonDTO("Chả giò chiên",41);
        monDTOs.add(monDTO16);
        MonDTO monDTO17 = new MonDTO("Cơm tấm sườn",527);
        monDTOs.add(monDTO17);
        MonDTO monDTO18 = new MonDTO("Chả cá thác lác chiên",133);
        monDTOs.add(monDTO18);
        MonDTO monDTO19 = new MonDTO("Chả lụa kho",133);
        monDTOs.add(monDTO19);
        MonDTO monDTO20 = new MonDTO("Chả trứng chưng",195);
        monDTOs.add(monDTO20);

        return monDTOs;
    }
}
