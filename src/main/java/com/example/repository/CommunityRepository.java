package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Community;


@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    public List<Community> findAllByOrderByNoDesc();

    public Community findByNo(long no);

    public Community findByMember_id(String id);


    // List<Community> findByTitleIgnoreCaseContainingOrderByNoDesc(String title);
    // List<Community> findByContentIgnoreCaseContainingOrderByNoDesc(String content);
    // List<Community> findByWriterIgnoreCaseContainingOrderByNoDesc(String writer);

    // //검색어+페이지네이션
    // List<Community> findByTitleIgnoreCaseContainingOrderByNoDesc(String title, Pageable pageable);
    // List<Community> findByContentIgnoreCaseContainingOrderByNoDesc(String content, Pageable pageable);
    // List<Community> findByWriterIgnoreCaseContainingOrderByNoDesc(String writer, Pageable pageable);
    
    // long countByTitleIgnoreCaseContainingOrderByNoDesc(String title);
    // long countByContentIgnoreCaseContainingOrderByNoDesc(String content);
    // long countByWriterIgnoreCaseContainingOrderByNoDesc(String writer);
    // // public Community updateCommuone(Community community);

    







   








   


   
    


}
