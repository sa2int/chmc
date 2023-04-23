package io.bigtreelab.rndbox.api.service;

import io.bigtreelab.rndbox.api.dto.closet.ClosetDto;
import io.bigtreelab.rndbox.api.dto.md.MdChoiceDto;
import io.bigtreelab.rndbox.api.dto.md.MdQueryDslDto;
import io.bigtreelab.rndbox.api.repository.ClosetRepository;
import io.bigtreelab.rndbox.api.repository.MdChoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClosetService {

    private final ClosetRepository closetRepository;
    private final MdChoiceRepository mdChoiceRepository;

    public List<ClosetDto> getCLoset(String choiceId) {
        return closetRepository.findAllClosetQueryDslInterfaceWithNative(choiceId.split(","))
                .stream()
                .map(ClosetDto::new)
                .collect(Collectors.toList());
    }

    public List<MdChoiceDto.Response> getMdChoice(String choiceId) {

        List<MdChoiceDto.Response> list = new ArrayList<MdChoiceDto.Response>();

        List<ClosetDto> topList = new ArrayList<>();
        List<ClosetDto> bottomList = new ArrayList<>();
        List<ClosetDto> outerList = new ArrayList<>();

        List<ClosetDto> closet = getCLoset(choiceId);

        for(int i=0; i<closet.size(); i++) {
            ClosetDto c = closet.get(i);
            switch (c.getCategoryPId()){
                case 1:
                    topList.add(c);
                    break;
                case 2:
                    bottomList.add(c);
                    break;
                case 3:
                    outerList.add(c);
                    break;
                default:
                    break;
            }
        }

        for(int i=0; i<topList.size(); i++) {
            ClosetDto t = topList.get(i);
            for(int j=0; j<bottomList.size(); j++) {
                ClosetDto s = bottomList.get(j);
                if(outerList.size()>0) {
                    for(int k=0; k<outerList.size(); k++) {
                        ClosetDto v = outerList.get(k);

                        MdChoiceDto.Response temp = mdChoiceRepository.findByCategoryIdTopAndColorIdTopAndCategoryIdPantsAndColorIdPantsAndCategoryIdOuterAndColorIdOuter(t.getCategoryId(),t.getColorId(),s.getCategoryId(),s.getColorId(),v.getCategoryId(),v.getColorId());
                        if(temp != null && temp.getMdChoiceId() != 0){
                            list.add(temp);
                        }
                    }
                } else {
                    MdChoiceDto.Response temp = mdChoiceRepository.findByCategoryIdTopAndColorIdTopAndCategoryIdPantsAndColorIdPants(t.getCategoryId(),t.getColorId(),s.getCategoryId(),s.getColorId());
                    if(temp != null && temp.getMdChoiceId() != 0){
                        list.add(temp);
                    }
                }
            }
        }
        return list;
    }
}
