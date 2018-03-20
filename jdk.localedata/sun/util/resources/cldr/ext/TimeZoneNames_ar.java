/*
 * Copyright (c) 2012, 2017, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * COPYRIGHT AND PERMISSION NOTICE
 *
 * Copyright (C) 1991-2016 Unicode, Inc. All rights reserved.
 * Distributed under the Terms of Use in 
 * http://www.unicode.org/copyright.html.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of the Unicode data files and any associated documentation
 * (the "Data Files") or Unicode software and any associated documentation
 * (the "Software") to deal in the Data Files or Software
 * without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, and/or sell copies of
 * the Data Files or Software, and to permit persons to whom the Data Files
 * or Software are furnished to do so, provided that
 * (a) this copyright and permission notice appear with all copies 
 * of the Data Files or Software,
 * (b) this copyright and permission notice appear in associated 
 * documentation, and
 * (c) there is clear notice in each modified Data File or in the Software
 * as well as in the documentation associated with the Data File(s) or
 * Software that the data or software has been modified.
 *
 * THE DATA FILES AND SOFTWARE ARE PROVIDED "AS IS", WITHOUT WARRANTY OF
 * ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT OF THIRD PARTY RIGHTS.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR HOLDERS INCLUDED IN THIS
 * NOTICE BE LIABLE FOR ANY CLAIM, OR ANY SPECIAL INDIRECT OR CONSEQUENTIAL
 * DAMAGES, OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE,
 * DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER
 * TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
 * PERFORMANCE OF THE DATA FILES OR SOFTWARE.
 *
 * Except as contained in this notice, the name of a copyright holder
 * shall not be used in advertising or otherwise to promote the sale,
 * use or other dealings in these Data Files or Software without prior
 * written authorization of the copyright holder.
 */

package sun.util.resources.cldr.ext;

import sun.util.resources.TimeZoneNamesBundle;

public class TimeZoneNames_ar extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0648\u0633\u0637 \u0623\u0641\u0631\u064a\u0642\u064a\u0627",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Moscow = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0648\u0633\u0643\u0648 \u0627\u0644\u0631\u0633\u0645\u064a",
               "MSK",
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0648\u0633\u0643\u0648 \u0627\u0644\u0635\u064a\u0641\u064a",
               "MSD",
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0648\u0633\u0643\u0648",
               "MT",
            };
        final String[] Japan = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u064a\u0627\u0628\u0627\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "JST",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u064a\u0627\u0628\u0627\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "JDT",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u064a\u0627\u0628\u0627\u0646",
               "JT",
            };
        final String[] Pakistan = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0627\u0643\u0633\u062a\u0627\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "PKT",
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0627\u0643\u0633\u062a\u0627\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "PKST",
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0627\u0643\u0633\u062a\u0627\u0646",
               "PKT",
            };
        final String[] Taipei = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0627\u064a\u0628\u064a\u0647 \u0627\u0644\u0631\u0633\u0645\u064a",
               "CST",
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0627\u064a\u0628\u064a\u0647 \u0627\u0644\u0635\u064a\u0641\u064a",
               "CDT",
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0627\u064a\u0628\u064a\u0647",
               "CT",
            };
        final String[] Hovd = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0647\u0648\u0641\u062f \u0627\u0644\u0631\u0633\u0645\u064a",
               "HOVT",
               "\u062a\u0648\u0642\u064a\u062a \u0647\u0648\u0641\u062f \u0627\u0644\u0635\u064a\u0641\u064a",
               "HOVST",
               "\u062a\u0648\u0642\u064a\u062a \u0647\u0648\u0641\u062f",
               "HOVT",
            };
        final String[] Magadan = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0627\u063a\u0627\u062f\u0627\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "MAGT",
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0627\u063a\u0627\u062f\u0627\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "MAGST",
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0627\u063a\u0627\u062f\u0627\u0646",
               "MAGT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0648\u0633\u0637 \u0623\u0633\u062a\u0631\u0627\u0644\u064a\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "ACWST",
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0648\u0633\u0637 \u0623\u0633\u062a\u0631\u0627\u0644\u064a\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "ACWDT",
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0648\u0633\u0637 \u0623\u0633\u062a\u0631\u0627\u0644\u064a\u0627",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0648\u0633\u0637 \u0623\u0648\u0631\u0648\u0628\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "CET",
               "\u062a\u0648\u0642\u064a\u062a \u0648\u0633\u0637 \u0623\u0648\u0631\u0648\u0628\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "CEST",
               "\u062a\u0648\u0642\u064a\u062a \u0648\u0633\u0637 \u0623\u0648\u0631\u0648\u0628\u0627",
               "CET",
            };
        final String[] Sakhalin = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0627\u062e\u0627\u0644\u064a\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "SAKT",
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0627\u062e\u0627\u0644\u064a\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "SAKST",
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0627\u062e\u0627\u0644\u064a\u0646",
               "SAKT",
            };
        final String[] Paraguay = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0627\u0631\u0627\u063a\u0648\u0627\u064a \u0627\u0644\u0631\u0633\u0645\u064a",
               "PYT",
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0627\u0631\u0627\u063a\u0648\u0627\u064a \u0627\u0644\u0635\u064a\u0641\u064a",
               "PYST",
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0627\u0631\u0627\u063a\u0648\u0627\u064a",
               "PYT",
            };
        final String[] Malaysia = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0627\u0644\u064a\u0632\u064a\u0627",
               "MYT",
               "Malaysia Summer Time",
               "MYST",
               "Malaysia Time",
               "MYT",
            };
        final String[] America_Eastern = new String[] {
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0631\u0633\u0645\u064a \u0627\u0644\u0634\u0631\u0642\u064a \u0644\u0623\u0645\u0631\u064a\u0643\u0627 \u0627\u0644\u0634\u0645\u0627\u0644\u064a\u0629",
               "EST",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0635\u064a\u0641\u064a \u0627\u0644\u0634\u0631\u0642\u064a \u0644\u0623\u0645\u0631\u064a\u0643\u0627 \u0627\u0644\u0634\u0645\u0627\u0644\u064a\u0629",
               "EDT",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0634\u0631\u0642\u064a \u0644\u0623\u0645\u0631\u064a\u0643\u0627 \u0627\u0644\u0634\u0645\u0627\u0644\u064a\u0629",
               "ET",
            };
        final String[] Lord_Howe = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0644\u0648\u0631\u062f \u0647\u0627\u0648 \u0627\u0644\u0631\u0633\u0645\u064a",
               "LHST",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0635\u064a\u0641\u064a \u0644\u0644\u0648\u0631\u062f \u0647\u0627\u0648",
               "LHDT",
               "\u062a\u0648\u0642\u064a\u062a \u0644\u0648\u0631\u062f \u0647\u0627\u0648",
               "LHT",
            };
        final String[] New_Zealand = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0646\u064a\u0648\u0632\u064a\u0644\u0646\u062f\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "NZST",
               "\u062a\u0648\u0642\u064a\u062a \u0646\u064a\u0648\u0632\u064a\u0644\u0646\u062f\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "NZDT",
               "\u062a\u0648\u0642\u064a\u062a \u0646\u064a\u0648\u0632\u064a\u0644\u0646\u062f\u0627",
               "NZT",
            };
        final String[] Indian_Ocean = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0645\u062d\u064a\u0637 \u0627\u0644\u0647\u0646\u062f\u064a",
               "IOT",
               "Indian Ocean Territory Summer Time",
               "IOST",
               "Indian Ocean Territory Time",
               "IOT",
            };
        final String[] Yakutsk = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u064a\u0627\u0643\u0648\u062a\u0633\u0643 \u0627\u0644\u0631\u0633\u0645\u064a",
               "YAKT",
               "\u062a\u0648\u0642\u064a\u062a \u064a\u0627\u0643\u0648\u062a\u0633\u0643 \u0627\u0644\u0635\u064a\u0641\u064a",
               "YAKST",
               "\u062a\u0648\u0642\u064a\u062a \u064a\u0627\u0643\u0648\u062a\u0633\u0643",
               "YAKT",
            };
        final String[] Mauritius = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0648\u0631\u064a\u0634\u064a\u0648\u0633 \u0627\u0644\u0631\u0633\u0645\u064a",
               "MUT",
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0648\u0631\u064a\u0634\u064a\u0648\u0633 \u0627\u0644\u0635\u064a\u0641\u064a",
               "MUST",
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0648\u0631\u064a\u0634\u064a\u0648\u0633",
               "MUT",
            };
        final String[] Africa_Eastern = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0631\u0642 \u0623\u0641\u0631\u064a\u0642\u064a\u0627",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] East_Timor = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062a\u064a\u0645\u0648\u0631 \u0627\u0644\u0634\u0631\u0642\u064a\u0629",
               "TLT",
               "Timor-Leste Summer Time",
               "TLST",
               "Timor-Leste Time",
               "TLT",
            };
        final String[] Solomon = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u0633\u0644\u064a\u0645\u0627\u0646",
               "SBT",
               "Solomon Is. Summer Time",
               "SBST",
               "Solomon Is. Time",
               "SBT",
            };
        final String[] Kosrae = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0648\u0633\u0631\u0627",
               "KOST",
               "Kosrae Summer Time",
               "KOSST",
               "Kosrae Time",
               "KOST",
            };
        final String[] Marshall_Islands = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u0645\u0627\u0631\u0634\u0627\u0644",
               "MHT",
               "Marshall Islands Summer Time",
               "MHST",
               "Marshall Islands Time",
               "MHT",
            };
        final String[] Europe_Eastern = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0631\u0642 \u0623\u0648\u0631\u0648\u0628\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "EET",
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0631\u0642 \u0623\u0648\u0631\u0648\u0628\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "EEST",
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0631\u0642 \u0623\u0648\u0631\u0648\u0628\u0627",
               "EET",
            };
        final String[] Newfoundland = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0646\u064a\u0648\u0641\u0627\u0648\u0646\u062f\u0644\u0627\u0646\u062f \u0627\u0644\u0631\u0633\u0645\u064a",
               "NST",
               "\u062a\u0648\u0642\u064a\u062a \u0646\u064a\u0648\u0641\u0627\u0648\u0646\u062f\u0644\u0627\u0646\u062f \u0627\u0644\u0635\u064a\u0641\u064a",
               "NDT",
               "\u062a\u0648\u0642\u064a\u062a \u0646\u064a\u0648\u0641\u0627\u0648\u0646\u062f\u0644\u0627\u0646\u062f",
               "NT",
            };
        final String[] Afghanistan = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0641\u063a\u0627\u0646\u0633\u062a\u0627\u0646",
               "AFT",
               "Afghanistan Summer Time",
               "AFST",
               "Afghanistan Time",
               "AFT",
            };
        final String[] Hong_Kong = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0647\u0648\u0646\u063a \u0643\u0648\u0646\u063a \u0627\u0644\u0631\u0633\u0645\u064a",
               "HKT",
               "\u062a\u0648\u0642\u064a\u062a \u0647\u0648\u0646\u063a \u0643\u0648\u0646\u063a \u0627\u0644\u0635\u064a\u0641\u064a",
               "HKST",
               "\u062a\u0648\u0642\u064a\u062a \u0647\u0648\u0646\u063a \u0643\u0648\u0646\u063a",
               "HKT",
            };
        final String[] Argentina_Western = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0627\u0644\u0623\u0631\u062c\u0646\u062a\u064a\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "ART",
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0627\u0644\u0623\u0631\u062c\u0646\u062a\u064a\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "ARST",
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0627\u0644\u0623\u0631\u062c\u0646\u062a\u064a\u0646",
               "ART",
            };
        final String[] Atlantic = new String[] {
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0631\u0633\u0645\u064a \u0627\u0644\u0623\u0637\u0644\u0633\u064a",
               "AST",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0635\u064a\u0641\u064a \u0627\u0644\u0623\u0637\u0644\u0633\u064a",
               "ADT",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0623\u0637\u0644\u0633\u064a",
               "AT",
            };
        final String[] Ponape = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0648\u0646\u0627\u0628\u064a",
               "PONT",
               "Pohnpei Summer Time",
               "PONST",
               "Ponape Time",
               "PONT",
            };
        final String[] Bolivia = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0648\u0644\u064a\u0641\u064a\u0627",
               "BOT",
               "Bolivia Summer Time",
               "BOST",
               "Bolivia Time",
               "BOT",
            };
        final String[] Pierre_Miquelon = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0627\u0646\u062a \u0628\u064a\u064a\u0631 \u0648\u0645\u064a\u0643\u0648\u0644\u0648\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "PMST",
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0627\u0646\u062a \u0628\u064a\u064a\u0631 \u0648\u0645\u064a\u0643\u0648\u0644\u0648\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "PMDT",
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0627\u0646\u062a \u0628\u064a\u064a\u0631 \u0648\u0645\u064a\u0643\u0648\u0644\u0648\u0646",
               "PMT",
            };
        final String[] Indochina = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0647\u0646\u062f \u0627\u0644\u0635\u064a\u0646\u064a\u0629",
               "ICT",
               "Indochina Summer Time",
               "ICST",
               "Indochina Time",
               "ICT",
            };
        final String[] Yekaterinburg = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u064a\u0643\u0627\u062a\u0631\u064a\u0646\u0628\u0648\u0631\u063a \u0627\u0644\u0631\u0633\u0645\u064a",
               "YEKT",
               "\u062a\u0648\u0642\u064a\u062a \u064a\u0643\u0627\u062a\u0631\u064a\u0646\u0628\u0648\u0631\u063a \u0627\u0644\u0635\u064a\u0641\u064a",
               "YEKST",
               "\u062a\u0648\u0642\u064a\u062a \u064a\u0643\u0627\u062a\u0631\u064a\u0646\u0628\u0648\u0631\u063a",
               "YEKT",
            };
        final String[] Maldives = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0640\u0645\u0627\u0644\u062f\u064a\u0641",
               "MVT",
               "Maldives Summer Time",
               "MVST",
               "Maldives Time",
               "MVT",
            };
        final String[] Tahiti = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0627\u0647\u064a\u062a\u064a",
               "TAHT",
               "Tahiti Summer Time",
               "TAHST",
               "Tahiti Time",
               "TAHT",
            };
        final String[] Israel = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0625\u0633\u0631\u0627\u0626\u064a\u0644 \u0627\u0644\u0631\u0633\u0645\u064a",
               "IST",
               "\u062a\u0648\u0642\u064a\u062a \u0625\u0633\u0631\u0627\u0626\u064a\u0644 \u0627\u0644\u0635\u064a\u0641\u064a",
               "IDT",
               "\u062a\u0648\u0642\u064a\u062a \u0625\u0633\u0631\u0627\u0626\u064a\u0644",
               "IT",
            };
        final String[] Indonesia_Central = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0648\u0633\u0637 \u0625\u0646\u062f\u0648\u0646\u064a\u0633\u064a\u0627",
               "WITA",
               "Central Indonesia Summer Time",
               "CIST",
               "Central Indonesia Time",
               "WITA",
            };
        final String[] Wallis = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0648\u0627\u0644\u064a\u0633 \u0648 \u0641\u0648\u062a\u0648\u0646\u0627",
               "WFT",
               "Wallis & Futuna Summer Time",
               "WFST",
               "Wallis & Futuna Time",
               "WFT",
            };
        final String[] Africa_Southern = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0646\u0648\u0628 \u0623\u0641\u0631\u064a\u0642\u064a\u0627",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Syowa = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0627\u064a\u0648\u0648\u0627",
               "SYOT",
               "Syowa Summer Time",
               "SYOST",
               "Syowa Time",
               "SYOT",
            };
        final String[] Line_Islands = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u0644\u0627\u064a\u0646",
               "LINT",
               "Line Is. Summer Time",
               "LINST",
               "Line Is. Time",
               "LINT",
            };
        final String[] Uzbekistan = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0648\u0632\u0628\u0643\u0633\u062a\u0627\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "UZT",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0648\u0632\u0628\u0643\u0633\u062a\u0627\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "UZST",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0648\u0632\u0628\u0643\u0633\u062a\u0627\u0646",
               "UZT",
            };
        final String[] Omsk = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0648\u0645\u0633\u0643 \u0627\u0644\u0631\u0633\u0645\u064a",
               "OMST",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0648\u0645\u0633\u0643 \u0627\u0644\u0635\u064a\u0641\u064a",
               "OMSST",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0648\u0645\u0633\u0643",
               "OMST",
            };
        final String[] Seychelles = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0633\u064a\u0634\u0644",
               "SCT",
               "Seychelles Summer Time",
               "SCST",
               "Seychelles Time",
               "SCT",
            };
        final String[] Uruguay = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0648\u0631\u063a\u0648\u0627\u064a \u0627\u0644\u0631\u0633\u0645\u064a",
               "UYT",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0648\u0631\u063a\u0648\u0627\u064a \u0627\u0644\u0635\u064a\u0641\u064a",
               "UYST",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0648\u0631\u063a\u0648\u0627\u064a",
               "UYT",
            };
        final String[] Nepal = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0646\u064a\u0628\u0627\u0644",
               "NPT",
               "Nepal Summer Time",
               "NPST",
               "Nepal Time",
               "NPT",
            };
        final String[] Mongolia = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0648\u0644\u0627\u0646 \u0628\u0627\u062a\u0648\u0631 \u0627\u0644\u0631\u0633\u0645\u064a",
               "ULAT",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0648\u0644\u0627\u0646 \u0628\u0627\u062a\u0648\u0631 \u0627\u0644\u0635\u064a\u0641\u064a",
               "ULAST",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0648\u0644\u0627\u0646 \u0628\u0627\u062a\u0648\u0631",
               "ULAT",
            };
        final String[] America_Central = new String[] {
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0631\u0633\u0645\u064a \u0627\u0644\u0645\u0631\u0643\u0632\u064a \u0644\u0623\u0645\u0631\u064a\u0643\u0627 \u0627\u0644\u0634\u0645\u0627\u0644\u064a\u0629",
               "CST",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0635\u064a\u0641\u064a \u0627\u0644\u0645\u0631\u0643\u0632\u064a \u0644\u0623\u0645\u0631\u064a\u0643\u0627 \u0627\u0644\u0634\u0645\u0627\u0644\u064a\u0629",
               "CDT",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0645\u0631\u0643\u0632\u064a \u0644\u0623\u0645\u0631\u064a\u0643\u0627 \u0627\u0644\u0634\u0645\u0627\u0644\u064a\u0629",
               "CT",
            };
        final String[] Truk = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0648\u0643",
               "CHUT",
               "Chuuk Summer Time",
               "CHUST",
               "Chuuk Time",
               "CHUT",
            };
        final String[] Niue = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0646\u064a\u0648\u064a",
               "NUT",
               "Niue Summer Time",
               "NUST",
               "Niue Time",
               "NUT",
            };
        final String[] Wake = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u064a\u0631\u0629 \u0648\u064a\u0643",
               "WAKT",
               "Wake Summer Time",
               "WAKST",
               "Wake Time",
               "WAKT",
            };
        final String[] Falkland = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u0641\u0648\u0643\u0644\u0627\u0646\u062f \u0627\u0644\u0631\u0633\u0645\u064a",
               "FKT",
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u0641\u0648\u0643\u0644\u0627\u0646\u062f \u0627\u0644\u0635\u064a\u0641\u064a",
               "FKST",
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u0641\u0648\u0643\u0644\u0627\u0646\u062f",
               "FKT",
            };
        final String[] Vanuatu = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0641\u0627\u0646\u0648\u0627\u062a\u0648 \u0627\u0644\u0631\u0633\u0645\u064a",
               "VUT",
               "\u062a\u0648\u0642\u064a\u062a \u0641\u0627\u0646\u0648\u0627\u062a\u0648 \u0627\u0644\u0635\u064a\u0641\u064a",
               "VUST",
               "\u062a\u0648\u0642\u064a\u062a \u0641\u0627\u0646\u0648\u0627\u062a\u0648",
               "VUT",
            };
        final String[] Novosibirsk = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0646\u0648\u0641\u0648\u0633\u064a\u0628\u064a\u0631\u0633\u0643 \u0627\u0644\u0631\u0633\u0645\u064a",
               "NOVT",
               "\u062a\u0648\u0642\u064a\u062a \u0646\u0648\u0641\u0648\u0633\u064a\u0628\u064a\u0631\u0633\u0643 \u0627\u0644\u0635\u064a\u0641\u064a",
               "NOVST",
               "\u062a\u0648\u0642\u064a\u062a \u0646\u0648\u0641\u0648\u0633\u064a\u0628\u064a\u0631\u0633\u0643",
               "NOVT",
            };
        final String[] Singapore = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0646\u063a\u0627\u0641\u0648\u0631\u0629",
               "SRET",
               "Srednekolymsk Daylight Time",
               "SREDT",
               "Srednekolymsk Time",
               "SRET",
            };
        final String[] Azores = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0632\u0648\u0631\u0633 \u0627\u0644\u0631\u0633\u0645\u064a",
               "AZOT",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0632\u0648\u0631\u0633 \u0627\u0644\u0635\u064a\u0641\u064a",
               "AZOST",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0632\u0648\u0631\u0633",
               "AZOT",
            };
        final String[] Apia = new String[] {
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0631\u0633\u0645\u064a \u0644\u0622\u0628\u064a\u0627",
               "WSST",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0635\u064a\u0641\u064a \u0644\u0623\u0628\u064a\u0627",
               "WSDT",
               "\u062a\u0648\u0642\u064a\u062a \u0622\u0628\u064a\u0627",
               "WST",
            };
        final String[] Bhutan = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0648\u062a\u0627\u0646",
               "BTT",
               "Bhutan Summer Time",
               "BTST",
               "Bhutan Time",
               "BTT",
            };
        final String[] Suriname = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0648\u0631\u064a\u0646\u0627\u0645",
               "SRT",
               "Suriname Summer Time",
               "SRST",
               "Suriname Time",
               "SRT",
            };
        final String[] Nauru = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0646\u0627\u0648\u0631\u0648",
               "NRT",
               "Nauru Summer Time",
               "NRST",
               "Nauru Time",
               "NRT",
            };
        final String[] Krasnoyarsk = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0631\u0627\u0633\u0646\u0648\u064a\u0627\u0631\u0633\u0643 \u0627\u0644\u0631\u0633\u0645\u064a",
               "KRAT",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0635\u064a\u0641\u064a \u0644\u0643\u0631\u0627\u0633\u0646\u0648\u064a\u0627\u0631\u0633\u0643",
               "KRAST",
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0631\u0627\u0633\u0646\u0648\u064a\u0627\u0631\u0633\u0643",
               "KRAT",
            };
        final String[] Kazakhstan_Western = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0643\u0627\u0632\u0627\u062e\u0633\u062a\u0627\u0646",
               "AQTT",
               "Aqtau Summer Time",
               "AQTST",
               "Aqtau Time",
               "AQTT",
            };
        final String[] Myanmar = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0645\u064a\u0627\u0646\u0645\u0627\u0631",
               "MMT",
               "Myanmar Summer Time",
               "MMST",
               "Myanmar Time",
               "MMT",
            };
        final String[] Christmas = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u0627\u0644\u0643\u0631\u064a\u0633\u0645\u0627\u0633",
               "CXT",
               "Christmas Island Summer Time",
               "CXST",
               "Christmas Island Time",
               "CIT",
            };
        final String[] Amazon = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0623\u0645\u0627\u0632\u0648\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "AMT",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0623\u0645\u0627\u0632\u0648\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "AMST",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0623\u0645\u0627\u0632\u0648\u0646",
               "AMT",
            };
        final String[] Kazakhstan_Eastern = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0631\u0642 \u0643\u0627\u0632\u0627\u062e\u0633\u062a\u0627\u0646",
               "ALMT",
               "Alma-Ata Summer Time",
               "ALMST",
               "Alma-Ata Time",
               "ALMT",
            };
        final String[] Fiji = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0641\u064a\u062c\u064a \u0627\u0644\u0631\u0633\u0645\u064a",
               "FJT",
               "\u062a\u0648\u0642\u064a\u062a \u0641\u064a\u062c\u064a \u0627\u0644\u0635\u064a\u0641\u064a",
               "FJST",
               "\u062a\u0648\u0642\u064a\u062a \u0641\u064a\u062c\u064a",
               "FJT",
            };
        final String[] Reunion = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0631\u064a\u0648\u0646\u064a\u0648\u0646",
               "RET",
               "Reunion Summer Time",
               "REST",
               "Reunion Time",
               "RET",
            };
        final String[] Cocos = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u0643\u0648\u0643\u0648\u0633",
               "CCT",
               "Cocos Islands Summer Time",
               "CCST",
               "Cocos Islands Time",
               "CCT",
            };
        final String[] Chatham = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0634\u0627\u062a\u0627\u0645 \u0627\u0644\u0631\u0633\u0645\u064a",
               "CHAST",
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0634\u0627\u062a\u0627\u0645 \u0627\u0644\u0635\u064a\u0641\u064a",
               "CHADT",
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0634\u0627\u062a\u0627\u0645",
               "CHAT",
            };
        final String[] Vostok = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0641\u0648\u0633\u062a\u0648\u0643",
               "VOST",
               "Vostok Summer Time",
               "VOSST",
               "Vostok Time",
               "VOST",
            };
        final String[] Argentina = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0623\u0631\u062c\u0646\u062a\u064a\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "ART",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0623\u0631\u062c\u0646\u062a\u064a\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "ARST",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0623\u0631\u062c\u0646\u062a\u064a\u0646",
               "ART",
            };
        final String[] Gambier = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0627\u0645\u0628\u064a\u0631",
               "GAMT",
               "Gambier Summer Time",
               "GAMST",
               "Gambier Time",
               "GAMT",
            };
        final String[] Kamchatka = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u064a\u062a\u0631\u0648\u0628\u0627\u0641\u0644\u0648\u0641\u0633\u0643-\u0643\u0627\u0645\u062a\u0634\u0627\u062a\u0633\u0643\u064a",
               "PETT",
               "\u062a\u0648\u0642\u064a\u062a \u0628\u064a\u062a\u0631\u0648\u0628\u0627\u0641\u0644\u0648\u0641\u0633\u0643-\u0643\u0627\u0645\u062a\u0634\u0627\u062a\u0633\u0643\u064a \u0627\u0644\u0635\u064a\u0641\u064a",
               "PETST",
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0627\u0645\u0634\u0627\u062a\u0643\u0627",
               "PETT",
            };
        final String[] Tuvalu = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0648\u0641\u0627\u0644\u0648",
               "TVT",
               "Tuvalu Summer Time",
               "TVST",
               "Tuvalu Time",
               "TVT",
            };
        final String[] Galapagos = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0644\u0627\u0628\u0627\u063a\u0648\u0633",
               "GALT",
               "Galapagos Summer Time",
               "GALST",
               "Galapagos Time",
               "GALT",
            };
        final String[] Macquarie = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0627\u0643\u0648\u0627\u0631\u064a",
               "MIST",
               "Macquarie Island Daylight Time",
               "MIDT",
               "Macquarie Island Time",
               "MIST",
            };
        final String[] Venezuela = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0641\u0646\u0632\u0648\u064a\u0644\u0627",
               "VET",
               "Venezuela Summer Time",
               "VEST",
               "Venezuela Time",
               "VET",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0647\u0627\u0648\u0627\u064a \u0623\u0644\u0648\u062a\u064a\u0627\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "HAST",
               "\u062a\u0648\u0642\u064a\u062a \u0647\u0627\u0648\u0627\u064a \u0623\u0644\u0648\u062a\u064a\u0627\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "HADT",
               "\u062a\u0648\u0642\u064a\u062a \u0647\u0627\u0648\u0627\u064a \u0623\u0644\u0648\u062a\u064a\u0627\u0646",
               "HAT",
            };
        final String[] Australia_Central = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0648\u0633\u0637 \u0623\u0633\u062a\u0631\u0627\u0644\u064a\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "ACST",
               "\u062a\u0648\u0642\u064a\u062a \u0648\u0633\u0637 \u0623\u0633\u062a\u0631\u0627\u0644\u064a\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "ACDT",
               "\u062a\u0648\u0642\u064a\u062a \u0648\u0633\u0637 \u0623\u0633\u062a\u0631\u0627\u0644\u064a\u0627",
               "ACT",
            };
        final String[] America_Pacific = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0645\u062d\u064a\u0637 \u0627\u0644\u0647\u0627\u062f\u064a \u0627\u0644\u0631\u0633\u0645\u064a",
               "PST",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0645\u062d\u064a\u0637 \u0627\u0644\u0647\u0627\u062f\u064a \u0627\u0644\u0635\u064a\u0641\u064a",
               "PDT",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0645\u062d\u064a\u0637 \u0627\u0644\u0647\u0627\u062f\u064a",
               "PT",
            };
        final String[] Phoenix_Islands = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u0641\u064a\u0646\u0643\u0633",
               "PHOT",
               "Phoenix Is. Summer Time",
               "PHOST",
               "Phoenix Is. Time",
               "PHOT",
            };
        final String[] Turkmenistan = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0631\u0643\u0645\u0627\u0646\u0633\u062a\u0627\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "TMT",
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0631\u0643\u0645\u0627\u0646\u0633\u062a\u0627\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "TMST",
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0631\u0643\u0645\u0627\u0646\u0633\u062a\u0627\u0646",
               "TMT",
            };
        final String[] Europe_Western = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0623\u0648\u0631\u0648\u0628\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "WET",
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0623\u0648\u0631\u0648\u0628\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "WEST",
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0623\u0648\u0631\u0648\u0628\u0627",
               "WET",
            };
        final String[] Cape_Verde = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0631\u0623\u0633 \u0627\u0644\u0623\u062e\u0636\u0631 \u0627\u0644\u0631\u0633\u0645\u064a",
               "CVT",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0631\u0623\u0633 \u0627\u0644\u0623\u062e\u0636\u0631 \u0627\u0644\u0635\u064a\u0641\u064a",
               "CVST",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0631\u0623\u0633 \u0627\u0644\u0623\u062e\u0636\u0631",
               "CVT",
            };
        final String[] Norfolk = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u064a\u0631\u0629 \u0646\u0648\u0631\u0641\u0648\u0644\u0643",
               "NFT",
               "Norfolk Summer Time",
               "NFST",
               "Norfolk Time",
               "NFT",
            };
        final String[] Guyana = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u063a\u064a\u0627\u0646\u0627",
               "GYT",
               "Guyana Summer Time",
               "GYST",
               "Guyana Time",
               "GYT",
            };
        final String[] Pitcairn = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u064a\u062a\u0643\u064a\u0631\u0646",
               "PST",
               "Pitcairn Daylight Time",
               "PDT",
               "Pitcairn Time",
               "PT",
            };
        final String[] Rothera = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0631\u0648\u062b\u064a\u0631\u0627",
               "ROTT",
               "Rothera Summer Time",
               "ROTST",
               "Rothera Time",
               "ROTT",
            };
        final String[] Samoa = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0627\u0645\u0648\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "SST",
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0627\u0645\u0648\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "SDT",
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0627\u0645\u0648\u0627",
               "ST",
            };
        final String[] Palau = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0627\u0644\u0627\u0648",
               "PWT",
               "Palau Summer Time",
               "PWST",
               "Palau Time",
               "PWT",
            };
        final String[] Europe_Further_Eastern = new String[] {
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0623\u0648\u0631\u0648\u0628\u064a (\u0623\u0643\u062b\u0631 \u0634\u0631\u0642\u064b\u0627)",
               "MSK",
               "Moscow Daylight Time",
               "MSD",
               "Moscow Time",
               "MT",
            };
        final String[] Azerbaijan = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0630\u0631\u0628\u064a\u062c\u0627\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "AZT",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0630\u0631\u0628\u064a\u062c\u0627\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "AZST",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0630\u0631\u0628\u064a\u062c\u0627\u0646",
               "AZT",
            };
        final String[] Mawson = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0627\u0648\u0633\u0648\u0646",
               "MAWT",
               "Mawson Summer Time",
               "MAWST",
               "Mawson Time",
               "MAWT",
            };
        final String[] Mexico_Pacific = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0645\u062d\u064a\u0637 \u0627\u0644\u0647\u0627\u062f\u064a \u0627\u0644\u0631\u0633\u0645\u064a \u0644\u0644\u0645\u0643\u0633\u064a\u0643",
               "MST",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0645\u062d\u064a\u0637 \u0627\u0644\u0647\u0627\u062f\u064a \u0627\u0644\u0635\u064a\u0641\u064a \u0644\u0644\u0645\u0643\u0633\u064a\u0643",
               "MDT",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0645\u062d\u064a\u0637 \u0627\u0644\u0647\u0627\u062f\u064a \u0644\u0644\u0645\u0643\u0633\u064a\u0643",
               "MT",
            };
        final String[] Davis = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062f\u0627\u0641\u064a\u0632",
               "DAVT",
               "Davis Summer Time",
               "DAVST",
               "Davis Time",
               "DAVT",
            };
        final String[] Cuba = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0648\u0628\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "CST",
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0648\u0628\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "CDT",
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0648\u0628\u0627",
               "CT",
            };
        final String[] Africa_Western = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0623\u0641\u0631\u064a\u0642\u064a\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "CAT",
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0623\u0641\u0631\u064a\u0642\u064a\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "CAST",
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0623\u0641\u0631\u064a\u0642\u064a\u0627",
               "CAT",
            };
        final String[] GMT = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u064a\u0646\u062a\u0634",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Philippines = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0641\u064a\u0644\u0628\u064a\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "PHT",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0641\u064a\u0644\u0628\u064a\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "PHST",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0641\u064a\u0644\u0628\u064a\u0646",
               "PHT",
            };
        final String[] French_Southern = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0645\u0642\u0627\u0637\u0639\u0627\u062a \u0627\u0644\u0641\u0631\u0646\u0633\u064a\u0629 \u0627\u0644\u062c\u0646\u0648\u0628\u064a\u0629 \u0648\u0627\u0644\u0623\u0646\u062a\u0627\u0631\u062a\u064a\u0643\u064a\u0629",
               "TFT",
               "French Southern & Antarctic Lands Summer Time",
               "TFST",
               "French Southern & Antarctic Lands Time",
               "TFT",
            };
        final String[] South_Georgia = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0646\u0648\u0628 \u062c\u0648\u0631\u062c\u064a\u0627",
               "GST",
               "South Georgia Daylight Time",
               "GDT",
               "South Georgia Time",
               "GT",
            };
        final String[] New_Caledonia = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0627\u0644\u064a\u062f\u0648\u0646\u064a\u0627 \u0627\u0644\u062c\u062f\u064a\u062f\u0629 \u0627\u0644\u0631\u0633\u0645\u064a",
               "NCT",
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0627\u0644\u064a\u062f\u0648\u0646\u064a\u0627 \u0627\u0644\u062c\u062f\u064a\u062f\u0629 \u0627\u0644\u0635\u064a\u0641\u064a",
               "NCST",
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0627\u0644\u064a\u062f\u0648\u0646\u064a\u0627 \u0627\u0644\u062c\u062f\u064a\u062f\u0629",
               "NCT",
            };
        final String[] Brunei = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0631\u0648\u0646\u0627\u064a",
               "BNT",
               "Brunei Summer Time",
               "BNST",
               "Brunei Time",
               "BNT",
            };
        final String[] Iran = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0625\u064a\u0631\u0627\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "IRST",
               "\u062a\u0648\u0642\u064a\u062a \u0625\u064a\u0631\u0627\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "IRDT",
               "\u062a\u0648\u0642\u064a\u062a \u0625\u064a\u0631\u0627\u0646",
               "IRT",
            };
        final String[] Easter = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u064a\u0631\u0629 \u0627\u0633\u062a\u0631 \u0627\u0644\u0631\u0633\u0645\u064a",
               "EAST",
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u064a\u0631\u0629 \u0627\u0633\u062a\u0631 \u0627\u0644\u0635\u064a\u0641\u064a",
               "EASST",
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u064a\u0631\u0629 \u0627\u0633\u062a\u0631",
               "EAST",
            };
        final String[] Mexico_Northwest = new String[] {
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0631\u0633\u0645\u064a \u0644\u0634\u0645\u0627\u0644 \u063a\u0631\u0628 \u0627\u0644\u0645\u0643\u0633\u064a\u0643",
               "PST",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0635\u064a\u0641\u064a \u0644\u0634\u0645\u0627\u0644 \u063a\u0631\u0628 \u0627\u0644\u0645\u0643\u0633\u064a\u0643",
               "PDT",
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0645\u0627\u0644 \u063a\u0631\u0628 \u0627\u0644\u0645\u0643\u0633\u064a\u0643",
               "PT",
            };
        final String[] DumontDUrville = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062f\u064a \u0645\u0648\u0646\u062a \u062f\u0648 \u0631\u0648\u0641\u064a\u0644",
               "DDUT",
               "Dumont-d'Urville Summer Time",
               "DDUST",
               "Dumont-d'Urville Time",
               "DDUT",
            };
        final String[] Tajikistan = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0637\u0627\u062c\u0643\u0633\u062a\u0627\u0646",
               "TJT",
               "Tajikistan Summer Time",
               "TJST",
               "Tajikistan Time",
               "TJT",
            };
        final String[] Tonga = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0648\u0646\u063a\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "TOT",
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0648\u0646\u063a\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "TOST",
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0648\u0646\u063a\u0627",
               "TOT",
            };
        final String[] Bangladesh = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0646\u062c\u0644\u0627\u062f\u064a\u0634 \u0627\u0644\u0631\u0633\u0645\u064a",
               "BDT",
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0646\u062c\u0644\u0627\u062f\u064a\u0634 \u0627\u0644\u0635\u064a\u0641\u064a",
               "BDST",
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0646\u062c\u0644\u0627\u062f\u064a\u0634",
               "BDT",
            };
        final String[] Peru = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u064a\u0631\u0648 \u0627\u0644\u0631\u0633\u0645\u064a",
               "PET",
               "\u062a\u0648\u0642\u064a\u062a \u0628\u064a\u0631\u0648 \u0627\u0644\u0635\u064a\u0641\u064a",
               "PEST",
               "\u062a\u0648\u0642\u064a\u062a \u0628\u064a\u0631\u0648",
               "PET",
            };
        final String[] Greenland_Western = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u063a\u0631\u064a\u0646\u0644\u0627\u0646\u062f \u0627\u0644\u0631\u0633\u0645\u064a",
               "WGT",
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u063a\u0631\u064a\u0646\u0644\u0627\u0646\u062f \u0627\u0644\u0635\u064a\u0641\u064a",
               "WGST",
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u063a\u0631\u064a\u0646\u0644\u0627\u0646\u062f",
               "WGT",
            };
        final String[] Ecuador = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0625\u0643\u0648\u0627\u062f\u0648\u0631",
               "ECT",
               "Ecuador Summer Time",
               "ECST",
               "Ecuador Time",
               "ECT",
            };
        final String[] Greenland_Eastern = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0631\u0642 \u063a\u0631\u064a\u0646\u0644\u0627\u0646\u062f \u0627\u0644\u0631\u0633\u0645\u064a",
               "EGT",
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0631\u0642 \u063a\u0631\u064a\u0646\u0644\u0627\u0646\u062f \u0627\u0644\u0635\u064a\u0641\u064a",
               "EGST",
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0631\u0642 \u063a\u0631\u064a\u0646\u0644\u0627\u0646\u062f",
               "EGT",
            };
        final String[] Gulf = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u062e\u0644\u064a\u062c",
               "GST",
               "Gulf Daylight Time",
               "GDT",
               "Gulf Time",
               "GT",
            };
        final String[] Indonesia_Eastern = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0631\u0642 \u0625\u0646\u062f\u0648\u0646\u064a\u0633\u064a\u0627",
               "WIT",
               "East Indonesia Summer Time",
               "EIST",
               "East Indonesia Time",
               "WIT",
            };
        final String[] Korea = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0648\u0631\u064a\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "KST",
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0648\u0631\u064a\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "KDT",
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0648\u0631\u064a\u0627",
               "KT",
            };
        final String[] Australia_Western = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0623\u0633\u062a\u0631\u0627\u0644\u064a\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "AWST",
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0623\u0633\u062a\u0631\u0627\u0644\u064a\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "AWDT",
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0623\u0633\u062a\u0631\u0627\u0644\u064a\u0627",
               "AWT",
            };
        final String[] Kyrgystan = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0642\u0631\u063a\u064a\u0632\u0633\u062a\u0627\u0646",
               "KGT",
               "Kirgizstan Summer Time",
               "KGST",
               "Kirgizstan Time",
               "KGT",
            };
        final String[] Indonesia_Western = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u0628 \u0625\u0646\u062f\u0648\u0646\u064a\u0633\u064a\u0627",
               "WIB",
               "West Indonesia Summer Time",
               "WIST",
               "West Indonesia Time",
               "WIB",
            };
        final String[] Australia_Eastern = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0631\u0642 \u0623\u0633\u062a\u0631\u0627\u0644\u064a\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "AEST",
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0631\u0642 \u0623\u0633\u062a\u0631\u0627\u0644\u064a\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "AEDT",
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0631\u0642 \u0623\u0633\u062a\u0631\u0627\u0644\u064a\u0627",
               "AET",
            };
        final String[] French_Guiana = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u063a\u0627\u064a\u0627\u0646\u0627 \u0627\u0644\u0641\u0631\u0646\u0633\u064a\u0629",
               "GFT",
               "French Guiana Summer Time",
               "GFST",
               "French Guiana Time",
               "GFT",
            };
        final String[] Colombia = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0648\u0644\u0648\u0645\u0628\u064a\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "COT",
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0648\u0644\u0648\u0645\u0628\u064a\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "COST",
               "\u062a\u0648\u0642\u064a\u062a \u0643\u0648\u0644\u0648\u0645\u0628\u064a\u0627",
               "COT",
            };
        final String[] Chile = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0634\u064a\u0644\u064a \u0627\u0644\u0631\u0633\u0645\u064a",
               "CLT",
               "\u062a\u0648\u0642\u064a\u062a \u0634\u064a\u0644\u064a \u0627\u0644\u0635\u064a\u0641\u064a",
               "CLST",
               "\u062a\u0648\u0642\u064a\u062a \u0634\u064a\u0644\u064a",
               "CLT",
            };
        final String[] Gilbert_Islands = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u062c\u064a\u0644\u0628\u0631\u062a",
               "GILT",
               "Gilbert Is. Summer Time",
               "GILST",
               "Gilbert Is. Time",
               "GILT",
            };
        final String[] America_Mountain = new String[] {
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u062c\u0628\u0644\u064a \u0627\u0644\u0631\u0633\u0645\u064a \u0644\u0623\u0645\u0631\u064a\u0643\u0627 \u0627\u0644\u0634\u0645\u0627\u0644\u064a\u0629",
               "MST",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u062c\u0628\u0644\u064a \u0627\u0644\u0635\u064a\u0641\u064a \u0644\u0623\u0645\u0631\u064a\u0643\u0627 \u0627\u0644\u0634\u0645\u0627\u0644\u064a\u0629",
               "MDT",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u062c\u0628\u0644\u064a \u0644\u0623\u0645\u0631\u064a\u0643\u0627 \u0627\u0644\u0634\u0645\u0627\u0644\u064a\u0629",
               "MT",
            };
        final String[] Marquesas = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0645\u0627\u0631\u0643\u064a\u0633\u0627\u0633",
               "MART",
               "Marquesas Summer Time",
               "MARST",
               "Marquesas Time",
               "MART",
            };
        final String[] Arabian = new String[] {
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0639\u0631\u0628\u064a \u0627\u0644\u0631\u0633\u0645\u064a",
               "AST",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0639\u0631\u0628\u064a \u0627\u0644\u0635\u064a\u0641\u064a",
               "ADT",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0639\u0631\u0628\u064a",
               "AT",
            };
        final String[] Alaska = new String[] {
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0631\u0633\u0645\u064a \u0644\u0623\u0644\u0627\u0633\u0643\u0627",
               "AKST",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0644\u0627\u0633\u0643\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "AKDT",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0644\u0627\u0633\u0643\u0627",
               "AKT",
            };
        final String[] Vladivostok = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0641\u0644\u0627\u062f\u064a\u0641\u0648\u0633\u062a\u0648\u0643 \u0627\u0644\u0631\u0633\u0645\u064a",
               "VLAT",
               "\u062a\u0648\u0642\u064a\u062a \u0641\u0644\u0627\u062f\u064a\u0641\u0648\u0633\u062a\u0648\u0643 \u0627\u0644\u0635\u064a\u0641\u064a",
               "VLAST",
               "\u062a\u0648\u0642\u064a\u062a \u0641\u0644\u0627\u062f\u064a\u0641\u0648\u0633\u062a\u0648\u0643",
               "VLAT",
            };
        final String[] Chamorro = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0634\u0627\u0645\u0648\u0631\u0648",
               "ChST",
               "Chamorro Daylight Time",
               "ChDT",
               "Chamorro Time",
               "ChT",
            };
        final String[] Irkutsk = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0625\u0631\u0643\u0648\u062a\u0633\u0643 \u0627\u0644\u0631\u0633\u0645\u064a",
               "IRKT",
               "\u062a\u0648\u0642\u064a\u062a \u0625\u0631\u0643\u0648\u062a\u0633\u0643 \u0627\u0644\u0635\u064a\u0641\u064a",
               "IRKST",
               "\u062a\u0648\u0642\u064a\u062a \u0625\u0631\u0643\u0648\u062a\u0633\u0643",
               "IRKT",
            };
        final String[] Georgia = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0648\u0631\u062c\u064a\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "GET",
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0648\u0631\u062c\u064a\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "GEST",
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0648\u0631\u062c\u064a\u0627",
               "GET",
            };
        final String[] Tokelau = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062a\u0648\u0643\u064a\u0644\u0627\u0648",
               "TKT",
               "Tokelau Summer Time",
               "TKST",
               "Tokelau Time",
               "TKT",
            };
        final String[] Papua_New_Guinea = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0627\u0628\u0648\u0627 \u063a\u064a\u0646\u064a\u0627 \u0627\u0644\u062c\u062f\u064a\u062f\u0629",
               "PGT",
               "Papua New Guinea Summer Time",
               "PGST",
               "Papua New Guinea Time",
               "PGT",
            };
        final String[] Noronha = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0641\u0631\u0646\u0627\u0646\u062f\u0648 \u062f\u064a \u0646\u0648\u0631\u0648\u0646\u0647\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "FNT",
               "\u062a\u0648\u0642\u064a\u062a \u0641\u0631\u0646\u0627\u0646\u062f\u0648 \u062f\u064a \u0646\u0648\u0631\u0648\u0646\u0647\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "FNST",
               "\u062a\u0648\u0642\u064a\u062a \u0641\u064a\u0631\u0646\u0627\u0646\u062f\u0648 \u062f\u064a \u0646\u0648\u0631\u0648\u0646\u0647\u0627",
               "FNT",
            };
        final String[] Choibalsan = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0648\u064a\u0628\u0627\u0644\u0633\u0627\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "CHOT",
               "\u0627\u0644\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0635\u064a\u0641\u064a \u0644\u0634\u0648\u064a\u0628\u0627\u0644\u0633\u0627\u0646",
               "CHOST",
               "\u062a\u0648\u0642\u064a\u062a \u0634\u0648\u064a\u0628\u0627\u0644\u0633\u0627\u0646",
               "CHOT",
            };
        final String[] Brasilia = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0631\u0627\u0632\u064a\u0644\u064a\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "BRT",
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0631\u0627\u0632\u064a\u0644\u064a\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "BRST",
               "\u062a\u0648\u0642\u064a\u062a \u0628\u0631\u0627\u0632\u064a\u0644\u064a\u0627",
               "BRT",
            };
        final String[] China = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0635\u064a\u0646 \u0627\u0644\u0631\u0633\u0645\u064a",
               "CST",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0635\u064a\u0646 \u0627\u0644\u0635\u064a\u0641\u064a",
               "CDT",
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0635\u064a\u0646",
               "CT",
            };
        final String[] Armenia = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0631\u0645\u064a\u0646\u064a\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
               "AMT",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0631\u0645\u064a\u0646\u064a\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "AMST",
               "\u062a\u0648\u0642\u064a\u062a \u0623\u0631\u0645\u064a\u0646\u064a\u0627",
               "AMT",
            };
        final String[] Samara = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0645\u0627\u0631\u0627",
               "SAMT",
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0645\u0627\u0631\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
               "SAMST",
               "\u062a\u0648\u0642\u064a\u062a \u0633\u0627\u0645\u0627\u0631\u0627",
               "SAMT",
            };
        final String[] India = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u0627\u0644\u0647\u0646\u062f",
               "IST",
               "India Daylight Time",
               "IDT",
               "India Time",
               "IT",
            };
        final String[] Cook = new String[] {
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u0643\u0648\u0648\u0643 \u0627\u0644\u0631\u0633\u0645\u064a",
               "CKT",
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u0643\u0648\u0648\u0643 \u0627\u0644\u0635\u064a\u0641\u064a",
               "CKHST",
               "\u062a\u0648\u0642\u064a\u062a \u062c\u0632\u0631 \u0643\u0648\u0648\u0643",
               "CKT",
            };
        final Object[][] data = new Object[][] {
            { "America/Los_Angeles", America_Pacific },
            { "America/Denver", America_Mountain },
            { "America/Phoenix", America_Mountain },
            { "America/Chicago", America_Central },
            { "America/New_York", America_Eastern },
            { "America/Indianapolis", America_Eastern },
            { "Pacific/Honolulu", Hawaii_Aleutian },
            { "America/Anchorage", Alaska },
            { "America/Halifax", Atlantic },
            { "America/Sitka", Alaska },
            { "America/St_Johns", Newfoundland },
            { "Europe/Paris", Europe_Central },
            { "GMT", GMT },
            { "Africa/Casablanca", Europe_Western },
            { "Asia/Jerusalem", Israel },
            { "Asia/Tokyo", Japan },
            { "Europe/Bucharest", Europe_Eastern },
            { "Asia/Shanghai", China },
            { "Asia/Aden", Arabian },
            { "America/Cuiaba", Amazon },
            { "Africa/Nairobi", Africa_Eastern },
            { "America/Marigot", Atlantic },
            { "Asia/Aqtau", Kazakhstan_Western },
            { "Pacific/Kwajalein", Marshall_Islands },
            { "America/El_Salvador", America_Central },
            { "Asia/Pontianak", Indonesia_Western },
            { "Africa/Cairo", Europe_Eastern },
            { "Pacific/Pago_Pago", Samoa },
            { "Africa/Mbabane", Africa_Southern },
            { "Asia/Kuching", Malaysia },
            { "Pacific/Rarotonga", Cook },
            { "America/Guatemala", America_Central },
            { "Australia/Hobart", Australia_Eastern },
            { "Europe/London",
                new String[] {
                    "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u064a\u0646\u062a\u0634",
                    "GMT",
                    "\u062a\u0648\u0642\u064a\u062a \u0628\u0631\u064a\u0637\u0627\u0646\u064a\u0627 \u0627\u0644\u0635\u064a\u0641\u064a",
                    "GMT",
                    "Greenwich Mean Time",
                    "GMT",
                }
            },
            { "America/Belize", America_Central },
            { "America/Panama", America_Eastern },
            { "America/Managua", America_Central },
            { "America/Indiana/Petersburg", America_Eastern },
            { "Asia/Yerevan", Armenia },
            { "Europe/Brussels", Europe_Central },
            { "Europe/Warsaw", Europe_Central },
            { "Europe/Jersey", GMT },
            { "America/Tegucigalpa", America_Central },
            { "Europe/Istanbul", Europe_Eastern },
            { "America/Miquelon", Pierre_Miquelon },
            { "Europe/Luxembourg", Europe_Central },
            { "Europe/Zaporozhye", Europe_Eastern },
            { "Atlantic/St_Helena", GMT },
            { "Europe/Guernsey", GMT },
            { "America/Grand_Turk", Atlantic },
            { "Asia/Samarkand", Uzbekistan },
            { "Asia/Phnom_Penh", Indochina },
            { "Africa/Kigali", Africa_Central },
            { "Asia/Almaty", Kazakhstan_Eastern },
            { "Asia/Dubai", Gulf },
            { "Europe/Isle_of_Man", GMT },
            { "America/Araguaina", Brasilia },
            { "Asia/Novosibirsk", Novosibirsk },
            { "America/Argentina/Salta", Argentina },
            { "Africa/Tunis", Europe_Central },
            { "Pacific/Fakaofo", Tokelau },
            { "Africa/Tripoli", Europe_Eastern },
            { "Africa/Banjul", GMT },
            { "Indian/Comoro", Africa_Eastern },
            { "Pacific/Port_Moresby", Papua_New_Guinea },
            { "Antarctica/Syowa", Syowa },
            { "Indian/Reunion", Reunion },
            { "Pacific/Palau", Palau },
            { "Europe/Kaliningrad", Europe_Eastern },
            { "America/Montevideo", Uruguay },
            { "Africa/Windhoek", Africa_Western },
            { "Asia/Karachi", Pakistan },
            { "Africa/Mogadishu", Africa_Eastern },
            { "Australia/Perth", Australia_Western },
            { "Asia/Chita", Yakutsk },
            { "Pacific/Easter", Easter },
            { "Antarctica/Davis", Davis },
            { "Antarctica/McMurdo", New_Zealand },
            { "America/Manaus", Amazon },
            { "Africa/Freetown", GMT },
            { "Asia/Macau", China },
            { "Europe/Malta", Europe_Central },
            { "Pacific/Tahiti", Tahiti },
            { "Africa/Asmera", Africa_Eastern },
            { "Europe/Busingen", Europe_Central },
            { "America/Argentina/Rio_Gallegos", Argentina },
            { "Africa/Malabo", Africa_Western },
            { "Europe/Skopje", Europe_Central },
            { "America/Catamarca", Argentina },
            { "America/Godthab", Greenland_Western },
            { "Europe/Sarajevo", Europe_Central },
            { "Africa/Lagos", Africa_Western },
            { "America/Cordoba", Argentina },
            { "Europe/Rome", Europe_Central },
            { "Indian/Mauritius", Mauritius },
            { "America/Regina", America_Central },
            { "America/Dawson_Creek", America_Mountain },
            { "Africa/Algiers", Europe_Central },
            { "Europe/Mariehamn", Europe_Eastern },
            { "America/St_Thomas", Atlantic },
            { "Europe/Zurich", Europe_Central },
            { "America/Anguilla", Atlantic },
            { "Asia/Dili", East_Timor },
            { "Africa/Bamako", GMT },
            { "Pacific/Wallis", Wallis },
            { "Europe/Gibraltar", Europe_Central },
            { "Africa/Conakry", GMT },
            { "Africa/Lubumbashi", Africa_Central },
            { "America/Havana", Cuba },
            { "Asia/Choibalsan", Choibalsan },
            { "Asia/Omsk", Omsk },
            { "Europe/Vaduz", Europe_Central },
            { "Asia/Dhaka", Bangladesh },
            { "America/Barbados", Atlantic },
            { "Atlantic/Cape_Verde", Cape_Verde },
            { "Asia/Yekaterinburg", Yekaterinburg },
            { "America/Louisville", America_Eastern },
            { "Pacific/Johnston", Hawaii_Aleutian },
            { "Pacific/Chatham", Chatham },
            { "Europe/Ljubljana", Europe_Central },
            { "America/Sao_Paulo", Brasilia },
            { "Asia/Jayapura", Indonesia_Eastern },
            { "America/Curacao", Atlantic },
            { "Asia/Dushanbe", Tajikistan },
            { "America/Guyana", Guyana },
            { "America/Guayaquil", Ecuador },
            { "America/Martinique", Atlantic },
            { "Europe/Berlin", Europe_Central },
            { "Europe/Moscow", Moscow },
            { "Europe/Chisinau", Europe_Eastern },
            { "America/Puerto_Rico", Atlantic },
            { "America/Rankin_Inlet", America_Central },
            { "Pacific/Ponape", Ponape },
            { "Europe/Stockholm", Europe_Central },
            { "Europe/Budapest", Europe_Central },
            { "Australia/Eucla", Australia_CentralWestern },
            { "Europe/Zagreb", Europe_Central },
            { "America/Port_of_Spain", Atlantic },
            { "Europe/Helsinki", Europe_Eastern },
            { "Asia/Beirut", Europe_Eastern },
            { "Pacific/Bougainville", New_Zealand },
            { "Africa/Sao_Tome", GMT },
            { "Indian/Chagos", Indian_Ocean },
            { "America/Cayenne", French_Guiana },
            { "Asia/Yakutsk", Yakutsk },
            { "Pacific/Galapagos", Galapagos },
            { "Africa/Ndjamena", Africa_Western },
            { "Pacific/Fiji", Fiji },
            { "America/Rainy_River", America_Central },
            { "Indian/Maldives", Maldives },
            { "Asia/Oral", Kazakhstan_Western },
            { "America/Yellowknife", America_Mountain },
            { "Pacific/Enderbury", Phoenix_Islands },
            { "America/Juneau", Alaska },
            { "America/Indiana/Vevay", America_Eastern },
            { "Asia/Tashkent", Uzbekistan },
            { "Asia/Jakarta", Indonesia_Western },
            { "Africa/Ceuta", Europe_Central },
            { "America/Recife", Brasilia },
            { "America/Buenos_Aires", Argentina },
            { "America/Noronha", Noronha },
            { "America/Swift_Current", America_Central },
            { "Australia/Adelaide", Australia_Central },
            { "America/Metlakatla", Alaska },
            { "Africa/Djibouti", Africa_Eastern },
            { "America/Paramaribo", Suriname },
            { "Europe/Simferopol", Moscow },
            { "Europe/Sofia", Europe_Eastern },
            { "Africa/Nouakchott", GMT },
            { "Europe/Prague", Europe_Central },
            { "America/Indiana/Vincennes", America_Eastern },
            { "Antarctica/Mawson", Mawson },
            { "America/Kralendijk", Atlantic },
            { "Antarctica/Troll", GMT },
            { "Europe/Samara", Samara },
            { "Indian/Christmas", Christmas },
            { "America/Antigua", Atlantic },
            { "Pacific/Gambier", Gambier },
            { "America/Inuvik", America_Mountain },
            { "America/Iqaluit", America_Eastern },
            { "Pacific/Funafuti", Tuvalu },
            { "Antarctica/Macquarie", Macquarie },
            { "America/Moncton", Atlantic },
            { "Africa/Gaborone", Africa_Central },
            { "America/St_Vincent", Atlantic },
            { "Asia/Gaza", Europe_Eastern },
            { "PST8PDT", America_Pacific },
            { "Atlantic/Faeroe", Europe_Western },
            { "Asia/Qyzylorda", Kazakhstan_Eastern },
            { "America/Yakutat", Alaska },
            { "Antarctica/Casey", Australia_Western },
            { "Europe/Copenhagen", Europe_Central },
            { "Atlantic/Azores", Azores },
            { "Europe/Vienna", Europe_Central },
            { "Pacific/Pitcairn", Pitcairn },
            { "America/Mazatlan", Mexico_Pacific },
            { "Pacific/Nauru", Nauru },
            { "Europe/Tirane", Europe_Central },
            { "Australia/Broken_Hill", Australia_Central },
            { "Europe/Riga", Europe_Eastern },
            { "America/Dominica", Atlantic },
            { "Africa/Abidjan", GMT },
            { "America/Mendoza", Argentina },
            { "America/Santarem", Brasilia },
            { "America/Asuncion", Paraguay },
            { "America/Boise", America_Mountain },
            { "Australia/Currie", Australia_Eastern },
            { "EST5EDT", America_Eastern },
            { "Pacific/Guam", Chamorro },
            { "Pacific/Wake", Wake },
            { "Atlantic/Bermuda", Atlantic },
            { "America/Costa_Rica", America_Central },
            { "America/Dawson", America_Pacific },
            { "Europe/Amsterdam", Europe_Central },
            { "America/Indiana/Knox", America_Central },
            { "America/North_Dakota/Beulah", America_Central },
            { "Africa/Accra", GMT },
            { "America/Maceio", Brasilia },
            { "Pacific/Apia", Apia },
            { "Pacific/Niue", Niue },
            { "Australia/Lord_Howe", Lord_Howe },
            { "Europe/Dublin",
                new String[] {
                    "\u062a\u0648\u0642\u064a\u062a \u063a\u0631\u064a\u0646\u062a\u0634",
                    "GMT",
                    "\u062a\u0648\u0642\u064a\u062a \u0623\u064a\u0631\u0644\u0646\u062f\u0627 \u0627\u0644\u0631\u0633\u0645\u064a",
                    "GMT",
                    "Greenwich Mean Time",
                    "GMT",
                }
            },
            { "Pacific/Truk", Truk },
            { "MST7MDT", America_Mountain },
            { "America/Monterrey", America_Central },
            { "America/Nassau", America_Eastern },
            { "America/Jamaica", America_Eastern },
            { "Asia/Bishkek", Kyrgystan },
            { "Atlantic/Stanley", Falkland },
            { "Indian/Mahe", Seychelles },
            { "Asia/Aqtobe", Kazakhstan_Western },
            { "Asia/Vladivostok", Vladivostok },
            { "Africa/Libreville", Africa_Western },
            { "Africa/Maputo", Africa_Central },
            { "America/Kentucky/Monticello", America_Eastern },
            { "Africa/El_Aaiun", Europe_Western },
            { "Africa/Ouagadougou", GMT },
            { "America/Coral_Harbour", America_Eastern },
            { "Pacific/Marquesas", Marquesas },
            { "America/Aruba", Atlantic },
            { "America/North_Dakota/Center", America_Central },
            { "America/Cayman", America_Eastern },
            { "Asia/Ulaanbaatar", Mongolia },
            { "Asia/Baghdad", Arabian },
            { "Europe/San_Marino", Europe_Central },
            { "America/Indiana/Tell_City", America_Central },
            { "America/Tijuana", America_Pacific },
            { "Pacific/Saipan", Chamorro },
            { "Africa/Douala", Africa_Western },
            { "America/Chihuahua", Mexico_Pacific },
            { "America/Ojinaga", America_Mountain },
            { "Asia/Hovd", Hovd },
            { "Antarctica/Rothera", Rothera },
            { "Asia/Damascus", Europe_Eastern },
            { "America/Argentina/San_Luis", Argentina_Western },
            { "America/Santiago", Chile },
            { "Asia/Baku", Azerbaijan },
            { "America/Argentina/Ushuaia", Argentina },
            { "Atlantic/Reykjavik", GMT },
            { "Africa/Brazzaville", Africa_Western },
            { "Africa/Porto-Novo", Africa_Western },
            { "America/La_Paz", Bolivia },
            { "Antarctica/DumontDUrville", DumontDUrville },
            { "Asia/Taipei", Taipei },
            { "Asia/Manila", Philippines },
            { "Asia/Bangkok", Indochina },
            { "Africa/Dar_es_Salaam", Africa_Eastern },
            { "Atlantic/Madeira", Europe_Western },
            { "Antarctica/Palmer", Chile },
            { "America/Thunder_Bay", America_Eastern },
            { "Africa/Addis_Ababa", Africa_Eastern },
            { "Europe/Uzhgorod", Europe_Eastern },
            { "America/Indiana/Marengo", America_Eastern },
            { "America/Creston", America_Mountain },
            { "America/Mexico_City", America_Central },
            { "Antarctica/Vostok", Vostok },
            { "Europe/Andorra", Europe_Central },
            { "Asia/Vientiane", Indochina },
            { "Pacific/Kiritimati", Line_Islands },
            { "America/Matamoros", America_Central },
            { "America/Blanc-Sablon", Atlantic },
            { "Asia/Riyadh", Arabian },
            { "Atlantic/South_Georgia", South_Georgia },
            { "Europe/Lisbon", Europe_Western },
            { "Europe/Oslo", Europe_Central },
            { "Asia/Novokuznetsk", Krasnoyarsk },
            { "CST6CDT", America_Central },
            { "Atlantic/Canary", Europe_Western },
            { "Asia/Kuwait", Arabian },
            { "Pacific/Efate", Vanuatu },
            { "Africa/Lome", GMT },
            { "America/Bogota", Colombia },
            { "America/Menominee", America_Central },
            { "America/Adak", Hawaii_Aleutian },
            { "Pacific/Norfolk", Norfolk },
            { "America/Resolute", America_Central },
            { "Pacific/Tarawa", Gilbert_Islands },
            { "Africa/Kampala", Africa_Eastern },
            { "Asia/Krasnoyarsk", Krasnoyarsk },
            { "America/Edmonton", America_Mountain },
            { "Europe/Podgorica", Europe_Central },
            { "Africa/Bujumbura", Africa_Central },
            { "America/Santo_Domingo", Atlantic },
            { "Europe/Minsk", Europe_Further_Eastern },
            { "Pacific/Auckland", New_Zealand },
            { "America/Glace_Bay", Atlantic },
            { "Asia/Qatar", Arabian },
            { "Europe/Kiev", Europe_Eastern },
            { "Asia/Magadan", Magadan },
            { "America/Port-au-Prince", America_Eastern },
            { "America/St_Barthelemy", Atlantic },
            { "Asia/Ashgabat", Turkmenistan },
            { "Africa/Luanda", Africa_Western },
            { "America/Nipigon", America_Eastern },
            { "Asia/Muscat", Gulf },
            { "Asia/Bahrain", Arabian },
            { "Europe/Vilnius", Europe_Eastern },
            { "America/Fortaleza", Brasilia },
            { "America/Hermosillo", Mexico_Pacific },
            { "America/Cancun", America_Eastern },
            { "Africa/Maseru", Africa_Southern },
            { "Pacific/Kosrae", Kosrae },
            { "Africa/Kinshasa", Africa_Western },
            { "Asia/Seoul", Korea },
            { "Australia/Sydney", Australia_Eastern },
            { "America/Lima", Peru },
            { "America/St_Lucia", Atlantic },
            { "Europe/Madrid", Europe_Central },
            { "America/Bahia_Banderas", America_Central },
            { "America/Montserrat", Atlantic },
            { "Asia/Brunei", Brunei },
            { "America/Santa_Isabel", Mexico_Northwest },
            { "America/Cambridge_Bay", America_Mountain },
            { "Asia/Colombo", India },
            { "Indian/Antananarivo", Africa_Eastern },
            { "Australia/Brisbane", Australia_Eastern },
            { "Indian/Mayotte", Africa_Eastern },
            { "Europe/Volgograd", Moscow },
            { "America/Lower_Princes", Atlantic },
            { "America/Vancouver", America_Pacific },
            { "Africa/Blantyre", Africa_Central },
            { "America/Danmarkshavn", GMT },
            { "America/Detroit", America_Eastern },
            { "America/Thule", Atlantic },
            { "Africa/Lusaka", Africa_Central },
            { "Asia/Hong_Kong", Hong_Kong },
            { "America/Argentina/La_Rioja", Argentina },
            { "Africa/Dakar", GMT },
            { "America/Tortola", Atlantic },
            { "America/Porto_Velho", Amazon },
            { "Asia/Sakhalin", Sakhalin },
            { "America/Scoresbysund", Greenland_Eastern },
            { "Asia/Kamchatka", Kamchatka },
            { "Africa/Harare", Africa_Central },
            { "America/Nome", Alaska },
            { "Europe/Tallinn", Europe_Eastern },
            { "Africa/Khartoum", Africa_Eastern },
            { "Africa/Johannesburg", Africa_Southern },
            { "Africa/Bangui", Africa_Western },
            { "Europe/Belgrade", Europe_Central },
            { "Africa/Bissau", GMT },
            { "Asia/Tehran", Iran },
            { "Africa/Juba", Africa_Eastern },
            { "America/Campo_Grande", Amazon },
            { "America/Belem", Brasilia },
            { "Asia/Saigon", Indochina },
            { "Pacific/Midway", Samoa },
            { "America/Jujuy", Argentina },
            { "America/Bahia", Brasilia },
            { "America/Goose_Bay", Atlantic },
            { "America/Pangnirtung", America_Eastern },
            { "Asia/Katmandu", Nepal },
            { "Africa/Niamey", Africa_Western },
            { "America/Whitehorse", America_Pacific },
            { "Pacific/Noumea", New_Caledonia },
            { "Asia/Tbilisi", Georgia },
            { "Asia/Makassar", Indonesia_Central },
            { "America/Argentina/San_Juan", Argentina },
            { "Asia/Nicosia", Europe_Eastern },
            { "America/Indiana/Winamac", America_Eastern },
            { "America/Boa_Vista", Amazon },
            { "America/Grenada", Atlantic },
            { "Australia/Darwin", Australia_Central },
            { "Asia/Khandyga", Yakutsk },
            { "Asia/Kuala_Lumpur", Malaysia },
            { "Asia/Thimphu", Bhutan },
            { "Asia/Rangoon", Myanmar },
            { "Europe/Bratislava", Europe_Central },
            { "Asia/Calcutta", India },
            { "America/Argentina/Tucuman", Argentina },
            { "Asia/Kabul", Afghanistan },
            { "Indian/Cocos", Cocos },
            { "Pacific/Tongatapu", Tonga },
            { "America/Merida", America_Central },
            { "America/St_Kitts", Atlantic },
            { "Arctic/Longyearbyen", Europe_Central },
            { "America/Fort_Nelson", America_Mountain },
            { "America/Caracas", Venezuela },
            { "America/Guadeloupe", Atlantic },
            { "Asia/Hebron", Europe_Eastern },
            { "Indian/Kerguelen", French_Southern },
            { "Africa/Monrovia", GMT },
            { "Asia/Ust-Nera", Vladivostok },
            { "Asia/Srednekolymsk", Singapore },
            { "America/North_Dakota/New_Salem", America_Central },
            { "Asia/Anadyr", Magadan },
            { "Australia/Melbourne", Australia_Eastern },
            { "Asia/Irkutsk", Irkutsk },
            { "America/Winnipeg", America_Central },
            { "Europe/Vatican", Europe_Central },
            { "Asia/Amman", Europe_Eastern },
            { "America/Toronto", America_Eastern },
            { "Asia/Singapore", Singapore },
            { "Australia/Lindeman", Australia_Eastern },
            { "Pacific/Majuro", Marshall_Islands },
            { "Pacific/Guadalcanal", Solomon },
            { "Europe/Athens", Europe_Eastern },
            { "Europe/Monaco", Europe_Central },
        };
        return data;
    }
}
