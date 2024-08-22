package org.getmane.restprojecttemplate.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Being {

    private Long id;

    private String name;

    private List<String> nicknames;
}
