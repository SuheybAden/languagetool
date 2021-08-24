/* LanguageTool, a natural language style checker 
 * Copyright (C) 2005 Daniel Naber (http://www.danielnaber.de)
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
package org.languagetool.rules.fr;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.languagetool.JLanguageTool;
import org.languagetool.Languages;
import org.languagetool.TestTools;
import org.languagetool.rules.AbstractCompoundRuleTest;
import org.languagetool.rules.RuleMatch;

public class CompoundRuleTest extends AbstractCompoundRuleTest {

  @Before
  public void setUp() throws Exception {
    lt = new JLanguageTool(Languages.getLanguageForShortCode("fr"));
    rule = new CompoundRule(TestTools.getMessages("fr"));
  }

  @Test
  public void testRule() throws IOException {
    // correct sentences:
    check(0, "Jésus-Christ");
    check(0, "Congo-Brazzaville");
    check(0, "vidéo-clip");

    // incorrect sentences:
    check(1, "Jésus Christ");
    check(1, "Congo Brazzaville");
    check(1, "Congo- Brazzaville");
    check(1, "Congo -Brazzaville");

    RuleMatch[] matches = rule.match(lt.getAnalyzedSentence("rez-de chaussée"));
    assertEquals(1, matches.length);
    assertEquals(1, matches[0].getSuggestedReplacements().size());
    assertEquals("rez-de-chaussée", matches[0].getSuggestedReplacements().get(0));

    matches = rule.match(lt.getAnalyzedSentence("Congo -Brazzaville"));
    assertEquals(1, matches.length);
    assertEquals(1, matches[0].getSuggestedReplacements().size());
    assertEquals("Congo-Brazzaville", matches[0].getSuggestedReplacements().get(0));

    matches = rule.match(lt.getAnalyzedSentence("Congo- Brazzaville"));
    assertEquals(1, matches.length);
    assertEquals(1, matches[0].getSuggestedReplacements().size());
    assertEquals("Congo-Brazzaville", matches[0].getSuggestedReplacements().get(0));

    matches = rule.match(lt.getAnalyzedSentence("Congo - Brazzaville"));
    assertEquals(1, matches.length);
    assertEquals(1, matches[0].getSuggestedReplacements().size());
    assertEquals("Congo-Brazzaville", matches[0].getSuggestedReplacements().get(0));

    matches = rule.match(lt.getAnalyzedSentence("le - quel"));
    assertEquals(1, matches.length);
    assertEquals(1, matches[0].getSuggestedReplacements().size());
    assertEquals("lequel", matches[0].getSuggestedReplacements().get(0));

    matches = rule.match(lt.getAnalyzedSentence("le quel"));
    assertEquals(1, matches.length);
    assertEquals(1, matches[0].getSuggestedReplacements().size());
    assertEquals("lequel", matches[0].getSuggestedReplacements().get(0));

    matches = rule.match(lt.getAnalyzedSentence("le- quel"));
    assertEquals(1, matches.length);
    assertEquals(1, matches[0].getSuggestedReplacements().size());
    assertEquals("lequel", matches[0].getSuggestedReplacements().get(0));

    matches = rule.match(lt.getAnalyzedSentence("anglo saxon"));
    assertEquals(1, matches.length);
    assertEquals(2, matches[0].getSuggestedReplacements().size());
    assertEquals("anglo-saxon", matches[0].getSuggestedReplacements().get(0));
    assertEquals("anglosaxon", matches[0].getSuggestedReplacements().get(1));

    matches = rule.match(lt.getAnalyzedSentence("anglo- saxon"));
    assertEquals(1, matches.length);
    assertEquals(2, matches[0].getSuggestedReplacements().size());
    assertEquals("anglo-saxon", matches[0].getSuggestedReplacements().get(0));
    assertEquals("anglosaxon", matches[0].getSuggestedReplacements().get(1));

    matches = rule.match(lt.getAnalyzedSentence("anglo -saxon"));
    assertEquals(1, matches.length);
    assertEquals(2, matches[0].getSuggestedReplacements().size());
    assertEquals("anglo-saxon", matches[0].getSuggestedReplacements().get(0));
    assertEquals("anglosaxon", matches[0].getSuggestedReplacements().get(1));

    matches = rule.match(lt.getAnalyzedSentence("anglo - saxon"));
    assertEquals(1, matches.length);
    assertEquals(2, matches[0].getSuggestedReplacements().size());
    assertEquals("anglo-saxon", matches[0].getSuggestedReplacements().get(0));
    assertEquals("anglosaxon", matches[0].getSuggestedReplacements().get(1));

  }

}
