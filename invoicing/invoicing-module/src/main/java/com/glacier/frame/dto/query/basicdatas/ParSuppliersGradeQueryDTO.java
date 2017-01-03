package com.glacier.frame.dto.query.basicdatas;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.glacier.frame.entity.basicdatas.ParSuppliersGrade;
import com.glacier.frame.entity.basicdatas.ParSuppliersGradeExample.Criteria;

/**
 * @ClassName: ParSuppliersGradeQueryDTO
 * @Description: TODO(供应商等级DTO)
 * @author songjundong
 * @email 985776597@QQ.com
 * @date 2015-1-13 下午1:24:47
 */
public class ParSuppliersGradeQueryDTO extends ParSuppliersGrade {
	private Date createStartTime;

	private Date createEndTime;

	public Date getCreateStartTime() {
		return createStartTime;
	}

	public void setCreateStartTime(Date createStartTime) {
		this.createStartTime = createStartTime;
	}

	public Date getCreateEndTime() {
		return createEndTime;
	}

	public void setCreateEndTime(Date createEndTime) {
		this.createEndTime = createEndTime;
	}

	public void setQueryCondition(Criteria queryCriteria) {
		if (null != this.getGradeName()
				&& StringUtils.isNotBlank(this.getGradeName())) {// 名称Like查询
			queryCriteria.andGradeNameLike("%" + this.getGradeName() + "%");
		}
		if (null != this.getEnabled()) {// 状态Enum查询
			queryCriteria.andEnabledEqualTo(this.getEnabled().toString());
		}
		if (null != createStartTime && null != createEndTime) {// 创建时间段查询
			queryCriteria.andCreateTimeBetween(createStartTime, createEndTime);
		} else {
			if (null != createStartTime) {
				queryCriteria
						.andCreateTimeGreaterThanOrEqualTo(createStartTime);
			}
			if (null != createEndTime) {
				queryCriteria.andCreateTimeLessThanOrEqualTo(createEndTime);
			}
		}
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
