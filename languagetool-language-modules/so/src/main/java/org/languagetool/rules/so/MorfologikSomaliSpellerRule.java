package org.languagetool.rules.so;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import org.languagetool.Language;
import org.languagetool.UserConfig;
import org.languagetool.rules.spelling.morfologik.MorfologikSpellerRule;

public class MorfologikSomaliSpellerRule extends MorfologikSpellerRule{
    public static final String RULE_ID = "MORFOLOGIK_RULE_SO";

    private static final String RESOURCE_FILENAME = "/so/hunspell/so_SO.dict";

    public MorfologikSomaliSpellerRule(ResourceBundle messages, Language language, UserConfig userConfig, List<Language> altLanguages) throws IOException {
        super(messages, language, userConfig, altLanguages);
    }

    @Override
    public String getFileName() {
        return RESOURCE_FILENAME;
    }

    @Override
    public String getId() {
        return RULE_ID;
    }
}
