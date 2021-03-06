package com.example.taglib;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectTagHandler extends SimpleTagSupport implements DynamicAttributes {
	private List optionsList;

	private String name;
	private String size;

	private HashMap<String, Object> tagAttrs = new HashMap<String, Object>();

	@Override
	public void setDynamicAttribute(String uri, String name, Object value) throws JspException {
		tagAttrs.put(name, value);

	}

	public static final String ATTR_TEMPLATE = "%s='%s' ";
	public static final String OPTION_TEMPLATE = "<option value='1$s'> %1$s </option>";

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		out.print("<select ");

		out.print(String.format(ATTR_TEMPLATE, "name", this.name));
//		out.print(String.format(OPTION_TEMPLATE, "size", this.size));
		for (String attrName : tagAttrs.keySet()) {
			String attrDefinition = String.format(ATTR_TEMPLATE, attrName, tagAttrs.get(attrName));
			out.print(attrDefinition);
		}

		out.println('>');

		for (Object option : this.optionsList) {
			String optionTag = String.format(OPTION_TEMPLATE, option.toString());
			out.println(optionTag);
		}
		out.println(" </select>");
	}

	public void setOptionsList(List optionsList) {
		this.optionsList = optionsList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
