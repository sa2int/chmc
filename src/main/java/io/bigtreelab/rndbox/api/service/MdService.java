package io.bigtreelab.rndbox.api.service;

import io.bigtreelab.rndbox.api.domain.md.MdCody;
import io.bigtreelab.rndbox.api.domain.md.MdCodyDetail;
import io.bigtreelab.rndbox.api.dto.Category.CategoryDto;
import io.bigtreelab.rndbox.api.dto.md.*;
import io.bigtreelab.rndbox.api.repository.MdCodyDetailRepository;
import io.bigtreelab.rndbox.api.repository.MdCodyRepository;
import io.bigtreelab.rndbox.api.repository.MdRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MdService {

    private final MdRepository mdRepository;
    private final MdCodyRepository mdCodyRepository;
    private final MdCodyDetailRepository mdCodyDetailRepository;

    @Transactional
    public MdDto.MdResponse saveMenu(MdDto.MdRequest mdRequest) {
        return new MdDto.MdResponse(mdRepository.save(mdRequest.toEntity()));
    }

    @Transactional
    public MdResponseDto saveMdCody(MdCodyRequestDto mdRequest) {

        MdCody mc = mdCodyRepository.save(mdRequest.toEntity());

        List<MdCodyDetail> mdCodyDetailList =
                mdCodyDetailRepository.saveAll(mdRequest.getMdCodyDetailList()
                        .stream().map((c) -> c.toEntity(mc.getMdCodyId()))
                        .collect(Collectors.toList()));



        return new MdResponseDto(mc, mdCodyDetailList);
    }

    public List<MdQueryDslDto> getMdList() {
        return mdRepository.findAllMdQueryDslInterfaceWithNative()
                .stream()
                .map(MdQueryDslDto::new)
                .collect(Collectors.toList());
    }

}
