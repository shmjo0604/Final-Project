package com.example.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.ActDetailCate;
import com.example.dto.ActivityCate;
import com.example.dto.CityCate;
import com.example.dto.ClassUnitView;
import com.example.dto.LocalCate;

@Mapper
public interface ClassSelectMapper {

    // 1. 클래스 조회 -> 날짜, 지역, 클래스 카테고리, 난이도, 가격 전달 받아서(pagination)
	public List<ClassUnitView> selectClassUnitViewList(Map<String, Object> map);
	
	/*
	 * // 1. 클래스 조회 -> 날짜, 지역, 클래스 카테고리, 난이도, 가격 전달 받아서(pagination)
	 * 
	 * @Select({ " <script> ", " SELECT s.* ", " FROM( ",
	 * " SELECT s.*, ROW_NUMBER() OVER(ORDER BY s.seregdate DESC) rnum FROM classsessionview s "
	 * , " <trim prefix='WHERE' prefixOverrides='AND || OR '> ",
	 * " <if test = 'map.citycode != 0' > ", " citycode = #{map.citycode} ",
	 * " </if> ", " <if test = 'map.localcode != 0'> ",
	 * " AND localcode = #{map.localcode} ", " </if> ",
	 * " <if test = 'map.activitycode != 0'> ",
	 * " AND activitycode = #{map.activitycode} ", " </if> ",
	 * " <if test = 'map.actcode != 0'> ", " AND actcode = #{map.actcode} ",
	 * " </if> ", " <if test = 'map.classdate != null'> ",
	 * " AND classdate = #{map.classdate} ", " </if> ",
	 * " <if test = 'map.classlevel != 0'> ",
	 * " AND classlevel = #{map.classlevel} ", " </if> ",
	 * " <if test = 'map.minprice != 0'> ",
	 * " AND totalprice <![CDATA[ > ]]> #{map.minprice} ", " </if> ",
	 * " <if test = 'map.maxprice != 0'> ",
	 * " AND totalprice <![CDATA[ < ]]> #{map.maxprice} ", " </if> ",
	 * " <if test = 'map.keyword != null'> ",
	 * " AND classtitle LIKE '%' ||  #{map.keyword} || '%' ",
	 * " OR talent LIKE '%' ||  #{map.keyword} || '%' ", " </if> ", " </trim> ",
	 * " ) s WHERE s.rnum >= ${map.first} and s.rnum <= ${map.last} ",
	 * " ORDER BY s.no DESC ", " </script> " }) public List<ClassSessionView>
	 * selectClassSessionViewList1(@Param("map") Map<String, Object> map);
	 */

	// 2. 뷰에서 클래스 코드가 중복인 것을 제거하고 하나만 조회 (가장 오래된 것)
	// @Select({ " <script> ",
	// 		" SELECT * FROM (SELECT *, ROW_NUMBER() OVER(PARTITION BY classcode ORDER BY no DESC) AS rown FROM CLASSSESSIONVIEW c) s WHERE rown = 1 AND chk = 1",
	// 		" <if test = 'map.citycode != 0' > ", " AND citycode = #{map.citycode} ", " </if> ",
	// 		" <if test = 'map.localcode != 0'> ", " AND localcode = #{map.localcode} ", " </if> ",
	// 		" <if test = 'map.activitycode != 0'> ", " AND activitycode = #{map.activitycode} ", " </if> ",
	// 		" <if test = 'map.actcode != 0'> ", " AND actcode = #{map.actcode} ", " </if> ",
	// 		" <if test = 'map.classdate != null'> ", " AND classdate = #{map.classdate} ", " </if> ",
	// 		" <if test = 'map.classlevel != 0'> ", " AND classlevel = #{map.classlevel} ", " </if> ",
	// 		" <if test = 'map.minprice != 0'> ", " AND totalprice <![CDATA[ > ]]> #{map.minprice} ", " </if> ",
	// 		" <if test = 'map.maxprice != 0'> ", " AND totalprice <![CDATA[ < ]]> #{map.maxprice} ", " </if> ",
	// 		" <if test = 'map.keyword != null'> ", " AND (title || intro || citycate || localcate || actdetailcate || actcate) LIKE '%' ||  #{map.keyword} || '%' ",
	// 		/* " OR talent LIKE '%' ||  #{map.keyword} || '%' ", */
	// 		" </if> ", " ORDER BY s.classcode DESC ", " </script> " })
	public List<ClassUnitView> selectClassSessionViewList2(Map<String, Object> map);

	// 3. 클래스 전체 조회

	// @Select({ " SELECT s.* FROM classsessionview s " })
	public List<ClassUnitView> selectClassProductList();

	// 4. 지역 상위 카테고리 조회
	public List<CityCate> selectCityCateList();

	// 5. 지역 하위 카테고리 조회 -> 상위 카테고리 코드 외래키로 전달 받아서
	public List<LocalCate> selectLocalCateList(int citycode);

	// 6. 클래스 상위 카테고리 조회
	public List<ActivityCate> selectActivityCateList();

	// 7. 클래스 하위 카테고리 조회 -> 상위 카테고리 코드 외래키로 전달 받아서
	public List<ActDetailCate> selectActDetailCateList(int actcode);

}
