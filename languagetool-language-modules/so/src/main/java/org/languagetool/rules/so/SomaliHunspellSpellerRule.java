/* LanguageTool, a natural language style checker
 * Copyright (C) 2019 Sohaib Afifi, Taha Zerrouki
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */

package org.languagetool.rules.so;

import org.jetbrains.annotations.NotNull;
import org.languagetool.UserConfig;
import org.languagetool.language.Somali;
import org.languagetool.rules.spelling.hunspell.HunspellRule;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class SomaliHunspellSpellerRule extends HunspellRule{
    
  public static final String RULE_ID = "HUNSPELL_RULE_SO";
  private static final String RESOURCE_FILENAME = "/so/hunspell/so.dic";

  public SomaliHunspellSpellerRule(ResourceBundle messages, UserConfig userConfig) {
    super(messages, new Somali(), userConfig);
  }

  public SomaliHunspellSpellerRule(ResourceBundle messages) {
    this(messages, null);
  }

  @Override
  public String getId() {
    return RULE_ID;
  }

  @Override
  @NotNull
  protected String getDictFilenameInResources(String langCountry) {
    return RESOURCE_FILENAME;
  }
  
  @Override
  protected boolean isLatinScript() {
    return true;
  }
}
