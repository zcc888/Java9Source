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

public class TimeZoneNames_ko extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "\uc911\uc559\uc544\ud504\ub9ac\uce74 \uc2dc\uac04",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Moscow = new String[] {
               "\ubaa8\uc2a4\ud06c\ubc14 \ud45c\uc900\uc2dc",
               "MSK",
               "\ubaa8\uc2a4\ud06c\ubc14 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "MSD",
               "\ubaa8\uc2a4\ud06c\ubc14 \uc2dc\uac04",
               "MT",
            };
        final String[] Japan = new String[] {
               "\uc77c\ubcf8 \ud45c\uc900\uc2dc",
               "JST",
               "\uc77c\ubcf8 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "JDT",
               "\uc77c\ubcf8 \uc2dc\uac04",
               "JT",
            };
        final String[] Pakistan = new String[] {
               "\ud30c\ud0a4\uc2a4\ud0c4 \ud45c\uc900\uc2dc",
               "PKT",
               "\ud30c\ud0a4\uc2a4\ud0c4 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "PKST",
               "\ud30c\ud0a4\uc2a4\ud0c4 \uc2dc\uac04",
               "PKT",
            };
        final String[] Taipei = new String[] {
               "\ub300\ub9cc \ud45c\uc900\uc2dc",
               "CST",
               "\ub300\ub9cc \ud558\uacc4 \ud45c\uc900\uc2dc",
               "CDT",
               "\ub300\ub9cc \uc2dc\uac04",
               "CT",
            };
        final String[] Hovd = new String[] {
               "\ud638\ube0c\ub4dc \ud45c\uc900\uc2dc",
               "HOVT",
               "\ud638\ube0c\ub4dc \ud558\uacc4 \ud45c\uc900\uc2dc",
               "HOVST",
               "\ud638\ube0c\ub4dc \uc2dc\uac04",
               "HOVT",
            };
        final String[] Magadan = new String[] {
               "\ub9c8\uac00\ub2e8 \ud45c\uc900\uc2dc",
               "MAGT",
               "\ub9c8\uac00\ub2e8 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "MAGST",
               "\ub9c8\uac00\ub2e8 \uc2dc\uac04",
               "MAGT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "\uc624\uc2a4\ud2b8\ub808\uc77c\ub9ac\uc544 \uc911\uc11c\ubd80 \ud45c\uc900\uc2dc",
               "ACWST",
               "\uc624\uc2a4\ud2b8\ub808\uc77c\ub9ac\uc544 \uc911\uc11c\ubd80 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "ACWDT",
               "\uc624\uc2a4\ud2b8\ub808\uc77c\ub9ac\uc544 \uc911\uc11c\ubd80 \uc2dc\uac04",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "\uc911\ubd80 \uc720\ub7fd \ud45c\uc900\uc2dc",
               "CET",
               "\uc911\ubd80 \uc720\ub7fd \ud558\uacc4 \ud45c\uc900\uc2dc",
               "CEST",
               "\uc911\ubd80 \uc720\ub7fd \uc2dc\uac04",
               "CET",
            };
        final String[] Sakhalin = new String[] {
               "\uc0ac\ud560\ub9b0 \ud45c\uc900\uc2dc",
               "SAKT",
               "\uc0ac\ud560\ub9b0 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "SAKST",
               "\uc0ac\ud560\ub9b0 \uc2dc\uac04",
               "SAKT",
            };
        final String[] Paraguay = new String[] {
               "\ud30c\ub77c\uacfc\uc774 \ud45c\uc900\uc2dc",
               "PYT",
               "\ud30c\ub77c\uacfc\uc774 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "PYST",
               "\ud30c\ub77c\uacfc\uc774 \uc2dc\uac04",
               "PYT",
            };
        final String[] Acre = new String[] {
               "\uc544\ud06c\ub808 \ud45c\uc900\uc2dc",
               "ACT",
               "\uc544\ud06c\ub808 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "ACST",
               "\uc544\ud06c\ub808 \uc2dc\uac04",
               "ACT",
            };
        final String[] Malaysia = new String[] {
               "\ub9d0\ub808\uc774\uc2dc\uc544 \uc2dc\uac04",
               "MYT",
               "Malaysia Summer Time",
               "MYST",
               "Malaysia Time",
               "MYT",
            };
        final String[] America_Eastern = new String[] {
               "\ubbf8 \ub3d9\ubd80 \ud45c\uc900\uc2dc",
               "EST",
               "\ubbf8 \ub3d9\ubd80 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "EDT",
               "\ubbf8 \ub3d9\ubd80 \uc2dc\uac04",
               "ET",
            };
        final String[] Lord_Howe = new String[] {
               "\ub85c\ub4dc \ud558\uc6b0 \ud45c\uc900\uc2dc",
               "LHST",
               "\ub85c\ub4dc \ud558\uc6b0 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "LHDT",
               "\ub85c\ub4dc \ud558\uc6b0 \uc2dc\uac04",
               "LHT",
            };
        final String[] New_Zealand = new String[] {
               "\ub274\uc9c8\ub79c\ub4dc \ud45c\uc900\uc2dc",
               "NZST",
               "\ub274\uc9c8\ub79c\ub4dc \ud558\uacc4 \ud45c\uc900\uc2dc",
               "NZDT",
               "\ub274\uc9c8\ub79c\ub4dc \uc2dc\uac04",
               "NZT",
            };
        final String[] Indian_Ocean = new String[] {
               "\uc778\ub3c4\uc591 \uc2dc\uac04",
               "IOT",
               "Indian Ocean Territory Summer Time",
               "IOST",
               "Indian Ocean Territory Time",
               "IOT",
            };
        final String[] Yakutsk = new String[] {
               "\uc57c\ucfe0\uce20\ud06c \ud45c\uc900\uc2dc",
               "YAKT",
               "\uc57c\ucfe0\uce20\ud06c \ud558\uacc4 \ud45c\uc900\uc2dc",
               "YAKST",
               "\uc57c\ucfe0\uce20\ud06c \uc2dc\uac04",
               "YAKT",
            };
        final String[] Mauritius = new String[] {
               "\ubaa8\ub9ac\uc154\uc2a4 \ud45c\uc900\uc2dc",
               "MUT",
               "\ubaa8\ub9ac\uc154\uc2a4 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "MUST",
               "\ubaa8\ub9ac\uc154\uc2a4 \uc2dc\uac04",
               "MUT",
            };
        final String[] Africa_Eastern = new String[] {
               "\ub3d9\uc544\ud504\ub9ac\uce74 \uc2dc\uac04",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] East_Timor = new String[] {
               "\ub3d9\ud2f0\ubaa8\ub974 \uc2dc\uac04",
               "TLT",
               "Timor-Leste Summer Time",
               "TLST",
               "Timor-Leste Time",
               "TLT",
            };
        final String[] Solomon = new String[] {
               "\uc194\ub85c\ubaac \uc81c\ub3c4 \uc2dc\uac04",
               "SBT",
               "Solomon Is. Summer Time",
               "SBST",
               "Solomon Is. Time",
               "SBT",
            };
        final String[] Kosrae = new String[] {
               "\ucf54\uc2a4\ub77c\uc5d0\uc12c \uc2dc\uac04",
               "KOST",
               "Kosrae Summer Time",
               "KOSST",
               "Kosrae Time",
               "KOST",
            };
        final String[] Marshall_Islands = new String[] {
               "\ub9c8\uc15c \uc81c\ub3c4 \uc2dc\uac04",
               "MHT",
               "Marshall Islands Summer Time",
               "MHST",
               "Marshall Islands Time",
               "MHT",
            };
        final String[] Europe_Eastern = new String[] {
               "\ub3d9\uc720\ub7fd \ud45c\uc900\uc2dc",
               "EET",
               "\ub3d9\uc720\ub7fd \ud558\uacc4 \ud45c\uc900\uc2dc",
               "EEST",
               "\ub3d9\uc720\ub7fd \uc2dc\uac04",
               "EET",
            };
        final String[] Newfoundland = new String[] {
               "\ub274\ud380\ub4e4\ub79c\ub4dc \ud45c\uc900\uc2dc",
               "NST",
               "\ub274\ud380\ub4e4\ub79c\ub4dc \ud558\uacc4 \ud45c\uc900\uc2dc",
               "NDT",
               "\ub274\ud380\ub4e4\ub79c\ub4dc \uc2dc\uac04",
               "NT",
            };
        final String[] Afghanistan = new String[] {
               "\uc544\ud504\uac00\ub2c8\uc2a4\ud0c4 \uc2dc\uac04",
               "AFT",
               "Afghanistan Summer Time",
               "AFST",
               "Afghanistan Time",
               "AFT",
            };
        final String[] Hong_Kong = new String[] {
               "\ud64d\ucf69 \ud45c\uc900\uc2dc",
               "HKT",
               "\ud64d\ucf69 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "HKST",
               "\ud64d\ucf69 \uc2dc\uac04",
               "HKT",
            };
        final String[] Argentina_Western = new String[] {
               "\uc544\ub974\ud5e8\ud2f0\ub098 \uc11c\ubd80 \ud45c\uc900\uc2dc",
               "ART",
               "\uc544\ub974\ud5e8\ud2f0\ub098 \uc11c\ubd80 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "ARST",
               "\uc544\ub974\ud5e8\ud2f0\ub098 \uc11c\ubd80 \uc2dc\uac04",
               "ART",
            };
        final String[] Atlantic = new String[] {
               "\ub300\uc11c\uc591 \ud45c\uc900\uc2dc",
               "AST",
               "\ubbf8 \ub300\uc11c\uc591 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "ADT",
               "\ub300\uc11c\uc591 \uc2dc\uac04",
               "AT",
            };
        final String[] Ponape = new String[] {
               "\ud3ec\ub098\ud398 \uc2dc\uac04",
               "PONT",
               "Pohnpei Summer Time",
               "PONST",
               "Ponape Time",
               "PONT",
            };
        final String[] Bolivia = new String[] {
               "\ubcfc\ub9ac\ube44\uc544 \uc2dc\uac04",
               "BOT",
               "Bolivia Summer Time",
               "BOST",
               "Bolivia Time",
               "BOT",
            };
        final String[] Pierre_Miquelon = new String[] {
               "\uc138\uc778\ud2b8\ud53c\uc5d0\ub974 \ubbf8\ud074\ub871 \ud45c\uc900\uc2dc",
               "PMST",
               "\uc138\uc778\ud2b8\ud53c\uc5d0\ub974 \ubbf8\ud074\ub871 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "PMDT",
               "\uc138\uc778\ud2b8\ud53c\uc5d0\ub974 \ubbf8\ud074\ub871 \uc2dc\uac04",
               "PMT",
            };
        final String[] Indochina = new String[] {
               "\uc778\ub3c4\ucc28\uc774\ub098 \uc2dc\uac04",
               "ICT",
               "Indochina Summer Time",
               "ICST",
               "Indochina Time",
               "ICT",
            };
        final String[] Yekaterinburg = new String[] {
               "\uc608\uce74\ud14c\ub9b0\ubd80\ub974\ud06c \ud45c\uc900\uc2dc",
               "YEKT",
               "\uc608\uce74\ud14c\ub9b0\ubd80\ub974\ud06c \ud558\uacc4 \ud45c\uc900\uc2dc",
               "YEKST",
               "\uc608\uce74\ud14c\ub9b0\ubd80\ub974\ud06c \uc2dc\uac04",
               "YEKT",
            };
        final String[] Maldives = new String[] {
               "\ubab0\ub514\ube0c \uc2dc\uac04",
               "MVT",
               "Maldives Summer Time",
               "MVST",
               "Maldives Time",
               "MVT",
            };
        final String[] Tahiti = new String[] {
               "\ud0c0\ud788\ud2f0 \uc2dc\uac04",
               "TAHT",
               "Tahiti Summer Time",
               "TAHST",
               "Tahiti Time",
               "TAHT",
            };
        final String[] Israel = new String[] {
               "\uc774\uc2a4\ub77c\uc5d8 \ud45c\uc900\uc2dc",
               "IST",
               "\uc774\uc2a4\ub77c\uc5d8 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "IDT",
               "\uc774\uc2a4\ub77c\uc5d8 \uc2dc\uac04",
               "IT",
            };
        final String[] Indonesia_Central = new String[] {
               "\uc911\ubd80 \uc778\ub3c4\ub124\uc2dc\uc544 \uc2dc\uac04",
               "WITA",
               "Central Indonesia Summer Time",
               "CIST",
               "Central Indonesia Time",
               "WITA",
            };
        final String[] Wallis = new String[] {
               "\uc6d4\ub9ac\uc2a4\ud478\ud22c\ub098 \uc81c\ub3c4 \uc2dc\uac04",
               "WFT",
               "Wallis & Futuna Summer Time",
               "WFST",
               "Wallis & Futuna Time",
               "WFT",
            };
        final String[] Africa_Southern = new String[] {
               "\ub0a8\uc544\ud504\ub9ac\uce74 \uc2dc\uac04",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Syowa = new String[] {
               "\uc1fc\uc640 \uc2dc\uac04",
               "SYOT",
               "Syowa Summer Time",
               "SYOST",
               "Syowa Time",
               "SYOT",
            };
        final String[] Line_Islands = new String[] {
               "\ub77c\uc778 \uc81c\ub3c4 \uc2dc\uac04",
               "LINT",
               "Line Is. Summer Time",
               "LINST",
               "Line Is. Time",
               "LINT",
            };
        final String[] Uzbekistan = new String[] {
               "\uc6b0\uc988\ubca0\ud0a4\uc2a4\ud0c4 \ud45c\uc900\uc2dc",
               "UZT",
               "\uc6b0\uc988\ubca0\ud0a4\uc2a4\ud0c4 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "UZST",
               "\uc6b0\uc988\ubca0\ud0a4\uc2a4\ud0c4 \uc2dc\uac04",
               "UZT",
            };
        final String[] Omsk = new String[] {
               "\uc634\uc2a4\ud06c \ud45c\uc900\uc2dc",
               "OMST",
               "\uc634\uc2a4\ud06c \ud558\uacc4 \ud45c\uc900\uc2dc",
               "OMSST",
               "\uc634\uc2a4\ud06c \uc2dc\uac04",
               "OMST",
            };
        final String[] Seychelles = new String[] {
               "\uc138\uc774\uc178 \uc2dc\uac04",
               "SCT",
               "Seychelles Summer Time",
               "SCST",
               "Seychelles Time",
               "SCT",
            };
        final String[] Uruguay = new String[] {
               "\uc6b0\ub8e8\uacfc\uc774 \ud45c\uc900\uc2dc",
               "UYT",
               "\uc6b0\ub8e8\uacfc\uc774 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "UYST",
               "\uc6b0\ub8e8\uacfc\uc774 \uc2dc\uac04",
               "UYT",
            };
        final String[] Nepal = new String[] {
               "\ub124\ud314 \uc2dc\uac04",
               "NPT",
               "Nepal Summer Time",
               "NPST",
               "Nepal Time",
               "NPT",
            };
        final String[] Mongolia = new String[] {
               "\uc6b8\ub780\ubc14\ud1a0\ub974 \ud45c\uc900\uc2dc",
               "ULAT",
               "\uc6b8\ub780\ubc14\ud1a0\ub974 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "ULAST",
               "\uc6b8\ub780\ubc14\ud1a0\ub974 \uc2dc\uac04",
               "ULAT",
            };
        final String[] America_Central = new String[] {
               "\ubbf8 \uc911\ubd80 \ud45c\uc900\uc2dc",
               "CST",
               "\ubbf8 \uc911\ubd80 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "CDT",
               "\ubbf8 \uc911\ubd80 \uc2dc\uac04",
               "CT",
            };
        final String[] Truk = new String[] {
               "\ucd94\ud06c \uc2dc\uac04",
               "CHUT",
               "Chuuk Summer Time",
               "CHUST",
               "Chuuk Time",
               "CHUT",
            };
        final String[] Niue = new String[] {
               "\ub2c8\uc6b0\uc5d0 \uc2dc\uac04",
               "NUT",
               "Niue Summer Time",
               "NUST",
               "Niue Time",
               "NUT",
            };
        final String[] Wake = new String[] {
               "\uc6e8\uc774\ud06c\uc12c \uc2dc\uac04",
               "WAKT",
               "Wake Summer Time",
               "WAKST",
               "Wake Time",
               "WAKT",
            };
        final String[] Falkland = new String[] {
               "\ud3ec\ud074\ub79c\ub4dc \uc81c\ub3c4 \ud45c\uc900\uc2dc",
               "FKT",
               "\ud3ec\ud074\ub79c\ub4dc \uc81c\ub3c4 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "FKST",
               "\ud3ec\ud074\ub79c\ub4dc \uc81c\ub3c4 \uc2dc\uac04",
               "FKT",
            };
        final String[] Vanuatu = new String[] {
               "\ubc14\ub204\uc544\ud22c \ud45c\uc900\uc2dc",
               "VUT",
               "\ubc14\ub204\uc544\ud22c \ud558\uacc4 \ud45c\uc900\uc2dc",
               "VUST",
               "\ubc14\ub204\uc544\ud22c \uc2dc\uac04",
               "VUT",
            };
        final String[] Novosibirsk = new String[] {
               "\ub178\ubcf4\uc2dc\ube44\ub974\uc2a4\ud06c \ud45c\uc900\uc2dc",
               "NOVT",
               "\ub178\ubcf4\uc2dc\ube44\ub974\uc2a4\ud06c \ud558\uacc4 \ud45c\uc900\uc2dc",
               "NOVST",
               "\ub178\ubcf4\uc2dc\ube44\ub974\uc2a4\ud06c \uc2dc\uac04",
               "NOVT",
            };
        final String[] Singapore = new String[] {
               "\uc2f1\uac00\ud3ec\ub974 \ud45c\uc900\uc2dc",
               "SRET",
               "Srednekolymsk Daylight Time",
               "SREDT",
               "Srednekolymsk Time",
               "SRET",
            };
        final String[] Azores = new String[] {
               "\uc544\uc870\ub808\uc2a4 \ud45c\uc900\uc2dc",
               "AZOT",
               "\uc544\uc870\ub808\uc2a4 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "AZOST",
               "\uc544\uc870\ub808\uc2a4 \uc2dc\uac04",
               "AZOT",
            };
        final String[] Apia = new String[] {
               "\uc544\ud53c\uc544 \ud45c\uc900\uc2dc",
               "WSST",
               "\uc544\ud53c\uc544 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "WSDT",
               "\uc544\ud53c\uc544 \uc2dc\uac04",
               "WST",
            };
        final String[] Bhutan = new String[] {
               "\ubd80\ud0c4 \uc2dc\uac04",
               "BTT",
               "Bhutan Summer Time",
               "BTST",
               "Bhutan Time",
               "BTT",
            };
        final String[] Suriname = new String[] {
               "\uc218\ub9ac\ub0a8 \uc2dc\uac04",
               "SRT",
               "Suriname Summer Time",
               "SRST",
               "Suriname Time",
               "SRT",
            };
        final String[] Nauru = new String[] {
               "\ub098\uc6b0\ub8e8 \uc2dc\uac04",
               "NRT",
               "Nauru Summer Time",
               "NRST",
               "Nauru Time",
               "NRT",
            };
        final String[] Krasnoyarsk = new String[] {
               "\ud06c\ub77c\uc2a4\ub178\uc57c\ub974\uc2a4\ud06c \ud45c\uc900\uc2dc",
               "KRAT",
               "\ud06c\ub77c\uc2a4\ub178\uc57c\ub974\uc2a4\ud06c \ud558\uacc4 \ud45c\uc900\uc2dc",
               "KRAST",
               "\ud06c\ub77c\uc2a4\ub178\uc57c\ub974\uc2a4\ud06c \uc2dc\uac04",
               "KRAT",
            };
        final String[] Kazakhstan_Western = new String[] {
               "\uc11c\ubd80 \uce74\uc790\ud750\uc2a4\ud0c4 \uc2dc\uac04",
               "AQTT",
               "Aqtau Summer Time",
               "AQTST",
               "Aqtau Time",
               "AQTT",
            };
        final String[] Myanmar = new String[] {
               "\ubbf8\uc580\ub9c8 \uc2dc\uac04",
               "MMT",
               "Myanmar Summer Time",
               "MMST",
               "Myanmar Time",
               "MMT",
            };
        final String[] Christmas = new String[] {
               "\ud06c\ub9ac\uc2a4\ub9c8\uc2a4\uc12c \uc2dc\uac04",
               "CXT",
               "Christmas Island Summer Time",
               "CXST",
               "Christmas Island Time",
               "CIT",
            };
        final String[] Amazon = new String[] {
               "\uc544\ub9c8\uc874 \ud45c\uc900\uc2dc",
               "AMT",
               "\uc544\ub9c8\uc874 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "AMST",
               "\uc544\ub9c8\uc874 \uc2dc\uac04",
               "AMT",
            };
        final String[] Kazakhstan_Eastern = new String[] {
               "\ub3d9\ubd80 \uce74\uc790\ud750\uc2a4\ud0c4 \uc2dc\uac04",
               "ALMT",
               "Alma-Ata Summer Time",
               "ALMST",
               "Alma-Ata Time",
               "ALMT",
            };
        final String[] Fiji = new String[] {
               "\ud53c\uc9c0 \ud45c\uc900\uc2dc",
               "FJT",
               "\ud53c\uc9c0 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "FJST",
               "\ud53c\uc9c0 \uc2dc\uac04",
               "FJT",
            };
        final String[] Reunion = new String[] {
               "\ub808\uc704\ub2c8\uc639 \uc2dc\uac04",
               "RET",
               "Reunion Summer Time",
               "REST",
               "Reunion Time",
               "RET",
            };
        final String[] Cocos = new String[] {
               "\ucf54\ucf54\uc2a4 \uc81c\ub3c4 \uc2dc\uac04",
               "CCT",
               "Cocos Islands Summer Time",
               "CCST",
               "Cocos Islands Time",
               "CCT",
            };
        final String[] Chatham = new String[] {
               "\ucc44\ud140 \ud45c\uc900\uc2dc",
               "CHAST",
               "\ucc44\ud140 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "CHADT",
               "\ucc44\ud140 \uc2dc\uac04",
               "CHAT",
            };
        final String[] Vostok = new String[] {
               "\ubcf4\uc2a4\ud1a1 \uc2dc\uac04",
               "VOST",
               "Vostok Summer Time",
               "VOSST",
               "Vostok Time",
               "VOST",
            };
        final String[] Argentina = new String[] {
               "\uc544\ub974\ud5e8\ud2f0\ub098 \ud45c\uc900\uc2dc",
               "ART",
               "\uc544\ub974\ud5e8\ud2f0\ub098 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "ARST",
               "\uc544\ub974\ud5e8\ud2f0\ub098 \uc2dc\uac04",
               "ART",
            };
        final String[] Gambier = new String[] {
               "\uac10\ube44\uc5d0 \uc2dc\uac04",
               "GAMT",
               "Gambier Summer Time",
               "GAMST",
               "Gambier Time",
               "GAMT",
            };
        final String[] Kamchatka = new String[] {
               "\ud398\ud2b8\ub85c\ud30c\ube14\ub86d\uc2a4\ud06c-\uce84\ucc28\uce20\ud0a4 \ud45c\uc900\uc2dc",
               "PETT",
               "\ud398\ud2b8\ub85c\ud30c\ube14\ub86d\uc2a4\ud06c-\uce84\ucc28\uce20\ud0a4 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "PETST",
               "\ud398\ud2b8\ub85c\ud30c\ube14\ub86d\uc2a4\ud06c-\uce84\ucc28\uce20\ud0a4 \uc2dc\uac04",
               "PETT",
            };
        final String[] Tuvalu = new String[] {
               "\ud22c\ubc1c\ub8e8 \uc2dc\uac04",
               "TVT",
               "Tuvalu Summer Time",
               "TVST",
               "Tuvalu Time",
               "TVT",
            };
        final String[] Galapagos = new String[] {
               "\uac08\ub77c\ud30c\uace0\uc2a4 \uc2dc\uac04",
               "GALT",
               "Galapagos Summer Time",
               "GALST",
               "Galapagos Time",
               "GALT",
            };
        final String[] Macquarie = new String[] {
               "\ub9e4\ucffc\ub9ac\uc12c \uc2dc\uac04",
               "MIST",
               "Macquarie Island Daylight Time",
               "MIDT",
               "Macquarie Island Time",
               "MIST",
            };
        final String[] Venezuela = new String[] {
               "\ubca0\ub124\uc218\uc5d8\ub77c \uc2dc\uac04",
               "VET",
               "Venezuela Summer Time",
               "VEST",
               "Venezuela Time",
               "VET",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "\ud558\uc640\uc774 \uc54c\ub958\uc0e8 \ud45c\uc900\uc2dc",
               "HAST",
               "\ud558\uc640\uc774 \uc54c\ub958\uc0e8 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "HADT",
               "\ud558\uc640\uc774 \uc54c\ub958\uc0e8 \uc2dc\uac04",
               "HAT",
            };
        final String[] Australia_Central = new String[] {
               "\uc624\uc2a4\ud2b8\ub808\uc77c\ub9ac\uc544 \uc911\ubd80 \ud45c\uc900\uc2dc",
               "ACST",
               "\uc624\uc2a4\ud2b8\ub808\uc77c\ub9ac\uc544 \uc911\ubd80 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "ACDT",
               "\uc624\uc2a4\ud2b8\ub808\uc77c\ub9ac\uc544 \uc911\ubd80 \uc2dc\uac04",
               "ACT",
            };
        final String[] America_Pacific = new String[] {
               "\ubbf8 \ud0dc\ud3c9\uc591 \ud45c\uc900\uc2dc",
               "PST",
               "\ubbf8 \ud0dc\ud3c9\uc591 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "PDT",
               "\ubbf8 \ud0dc\ud3c9\uc591 \uc2dc\uac04",
               "PT",
            };
        final String[] Phoenix_Islands = new String[] {
               "\ud53c\ub2c9\uc2a4 \uc81c\ub3c4 \uc2dc\uac04",
               "PHOT",
               "Phoenix Is. Summer Time",
               "PHOST",
               "Phoenix Is. Time",
               "PHOT",
            };
        final String[] Turkmenistan = new String[] {
               "\ud22c\ub974\ud06c\uba54\ub2c8\uc2a4\ud0c4 \ud45c\uc900\uc2dc",
               "TMT",
               "\ud22c\ub974\ud06c\uba54\ub2c8\uc2a4\ud0c4 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "TMST",
               "\ud22c\ub974\ud06c\uba54\ub2c8\uc2a4\ud0c4 \uc2dc\uac04",
               "TMT",
            };
        final String[] Europe_Western = new String[] {
               "\uc11c\uc720\ub7fd \ud45c\uc900\uc2dc",
               "WET",
               "\uc11c\uc720\ub7fd \ud558\uacc4 \ud45c\uc900\uc2dc",
               "WEST",
               "\uc11c\uc720\ub7fd \uc2dc\uac04",
               "WET",
            };
        final String[] Cape_Verde = new String[] {
               "\uce74\ubcf4 \ubca0\ub974\ub370 \ud45c\uc900\uc2dc",
               "CVT",
               "\uce74\ubcf4 \ubca0\ub974\ub370 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "CVST",
               "\uce74\ubcf4 \ubca0\ub974\ub370 \uc2dc\uac04",
               "CVT",
            };
        final String[] Norfolk = new String[] {
               "\ub178\ud37d\uc12c \uc2dc\uac04",
               "NFT",
               "Norfolk Summer Time",
               "NFST",
               "Norfolk Time",
               "NFT",
            };
        final String[] Guyana = new String[] {
               "\uac00\uc774\uc544\ub098 \uc2dc\uac04",
               "GYT",
               "Guyana Summer Time",
               "GYST",
               "Guyana Time",
               "GYT",
            };
        final String[] Pitcairn = new String[] {
               "\ud54f\ucf00\uc5b8 \uc2dc\uac04",
               "PST",
               "Pitcairn Daylight Time",
               "PDT",
               "Pitcairn Time",
               "PT",
            };
        final String[] Rothera = new String[] {
               "\ub85c\ub370\ub77c \uc2dc\uac04",
               "ROTT",
               "Rothera Summer Time",
               "ROTST",
               "Rothera Time",
               "ROTT",
            };
        final String[] Samoa = new String[] {
               "\uc0ac\ubaa8\uc544 \ud45c\uc900\uc2dc",
               "SST",
               "\uc0ac\ubaa8\uc544 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "SDT",
               "\uc0ac\ubaa8\uc544 \uc2dc\uac04",
               "ST",
            };
        final String[] Palau = new String[] {
               "\ud314\ub77c\uc6b0 \uc2dc\uac04",
               "PWT",
               "Palau Summer Time",
               "PWST",
               "Palau Time",
               "PWT",
            };
        final String[] Europe_Further_Eastern = new String[] {
               "\uadf9\ub3d9 \uc720\ub7fd \ud45c\uc900\uc2dc",
               "MSK",
               "Moscow Daylight Time",
               "MSD",
               "Moscow Time",
               "MT",
            };
        final String[] Azerbaijan = new String[] {
               "\uc544\uc81c\ub974\ubc14\uc774\uc794 \ud45c\uc900\uc2dc",
               "AZT",
               "\uc544\uc81c\ub974\ubc14\uc774\uc794 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "AZST",
               "\uc544\uc81c\ub974\ubc14\uc774\uc794 \uc2dc\uac04",
               "AZT",
            };
        final String[] Mawson = new String[] {
               "\ubaa8\uc2a8 \uc2dc\uac04",
               "MAWT",
               "Mawson Summer Time",
               "MAWST",
               "Mawson Time",
               "MAWT",
            };
        final String[] Mexico_Pacific = new String[] {
               "\uba55\uc2dc\ucf54 \ud0dc\ud3c9\uc591 \ud45c\uc900\uc2dc",
               "MST",
               "\uba55\uc2dc\ucf54 \ud0dc\ud3c9\uc591 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "MDT",
               "\uba55\uc2dc\ucf54 \ud0dc\ud3c9\uc591 \uc2dc\uac04",
               "MT",
            };
        final String[] Davis = new String[] {
               "\ub370\uc774\ube44\uc2a4 \uc2dc\uac04",
               "DAVT",
               "Davis Summer Time",
               "DAVST",
               "Davis Time",
               "DAVT",
            };
        final String[] Cuba = new String[] {
               "\ucfe0\ubc14 \ud45c\uc900\uc2dc",
               "CST",
               "\ucfe0\ubc14 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "CDT",
               "\ucfe0\ubc14 \uc2dc\uac04",
               "CT",
            };
        final String[] Africa_Western = new String[] {
               "\uc11c\uc544\ud504\ub9ac\uce74 \ud45c\uc900\uc2dc",
               "CAT",
               "\uc11c\uc544\ud504\ub9ac\uce74 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "CAST",
               "\uc11c\uc544\ud504\ub9ac\uce74 \uc2dc\uac04",
               "CAT",
            };
        final String[] GMT = new String[] {
               "\uadf8\ub9ac\ub2c8\uce58 \ud45c\uc900\uc2dc",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Philippines = new String[] {
               "\ud544\ub9ac\ud540 \ud45c\uc900\uc2dc",
               "PHT",
               "\ud544\ub9ac\ud540 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "PHST",
               "\ud544\ub9ac\ud540 \uc2dc\uac04",
               "PHT",
            };
        final String[] French_Southern = new String[] {
               "\ud504\ub791\uc2a4\ub839 \ub0a8\ubd80 \uc2dd\ubbfc\uc9c0 \ubc0f \ub0a8\uadf9 \uc2dc\uac04",
               "TFT",
               "French Southern & Antarctic Lands Summer Time",
               "TFST",
               "French Southern & Antarctic Lands Time",
               "TFT",
            };
        final String[] South_Georgia = new String[] {
               "\uc0ac\uc6b0\uc2a4 \uc870\uc9c0\uc544 \uc2dc\uac04",
               "GST",
               "South Georgia Daylight Time",
               "GDT",
               "South Georgia Time",
               "GT",
            };
        final String[] New_Caledonia = new String[] {
               "\ub274\uce7c\ub808\ub3c4\ub2c8\uc544 \ud45c\uc900\uc2dc",
               "NCT",
               "\ub274\uce7c\ub808\ub3c4\ub2c8\uc544 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "NCST",
               "\ub274\uce7c\ub808\ub3c4\ub2c8\uc544 \uc2dc\uac04",
               "NCT",
            };
        final String[] Brunei = new String[] {
               "\ube0c\ub8e8\ub098\uc774 \uc2dc\uac04",
               "BNT",
               "Brunei Summer Time",
               "BNST",
               "Brunei Time",
               "BNT",
            };
        final String[] Iran = new String[] {
               "\uc774\ub780 \ud45c\uc900\uc2dc",
               "IRST",
               "\uc774\ub780 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "IRDT",
               "\uc774\ub780 \uc2dc\uac04",
               "IRT",
            };
        final String[] Easter = new String[] {
               "\uc774\uc2a4\ud130\uc12c \ud45c\uc900\uc2dc",
               "EAST",
               "\uc774\uc2a4\ud130\uc12c \ud558\uacc4 \ud45c\uc900\uc2dc",
               "EASST",
               "\uc774\uc2a4\ud130\uc12c \uc2dc\uac04",
               "EAST",
            };
        final String[] Mexico_Northwest = new String[] {
               "\uba55\uc2dc\ucf54 \ubd81\uc11c\ubd80 \ud45c\uc900\uc2dc",
               "PST",
               "\uba55\uc2dc\ucf54 \ubd81\uc11c\ubd80 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "PDT",
               "\uba55\uc2dc\ucf54 \ubd81\uc11c\ubd80 \uc2dc\uac04",
               "PT",
            };
        final String[] DumontDUrville = new String[] {
               "\ub4a4\ubabd\ub4a4\ub974\ube4c \uc2dc\uac04",
               "DDUT",
               "Dumont-d'Urville Summer Time",
               "DDUST",
               "Dumont-d'Urville Time",
               "DDUT",
            };
        final String[] Tajikistan = new String[] {
               "\ud0c0\uc9c0\ud0a4\uc2a4\ud0c4 \uc2dc\uac04",
               "TJT",
               "Tajikistan Summer Time",
               "TJST",
               "Tajikistan Time",
               "TJT",
            };
        final String[] Tonga = new String[] {
               "\ud1b5\uac00 \ud45c\uc900\uc2dc",
               "TOT",
               "\ud1b5\uac00 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "TOST",
               "\ud1b5\uac00 \uc2dc\uac04",
               "TOT",
            };
        final String[] Bangladesh = new String[] {
               "\ubc29\uae00\ub77c\ub370\uc2dc \ud45c\uc900\uc2dc",
               "BDT",
               "\ubc29\uae00\ub77c\ub370\uc2dc \ud558\uacc4 \ud45c\uc900\uc2dc",
               "BDST",
               "\ubc29\uae00\ub77c\ub370\uc2dc \uc2dc\uac04",
               "BDT",
            };
        final String[] Peru = new String[] {
               "\ud398\ub8e8 \ud45c\uc900\uc2dc",
               "PET",
               "\ud398\ub8e8 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "PEST",
               "\ud398\ub8e8 \uc2dc\uac04",
               "PET",
            };
        final String[] Greenland_Western = new String[] {
               "\uadf8\ub9b0\ub780\ub4dc \uc11c\ubd80 \ud45c\uc900\uc2dc",
               "WGT",
               "\uadf8\ub9b0\ub780\ub4dc \uc11c\ubd80 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "WGST",
               "\uadf8\ub9b0\ub780\ub4dc \uc11c\ubd80 \uc2dc\uac04",
               "WGT",
            };
        final String[] Ecuador = new String[] {
               "\uc5d0\ucf70\ub3c4\ub974 \uc2dc\uac04",
               "ECT",
               "Ecuador Summer Time",
               "ECST",
               "Ecuador Time",
               "ECT",
            };
        final String[] Greenland_Eastern = new String[] {
               "\uadf8\ub9b0\ub780\ub4dc \ub3d9\ubd80 \ud45c\uc900\uc2dc",
               "EGT",
               "\uadf8\ub9b0\ub780\ub4dc \ub3d9\ubd80 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "EGST",
               "\uadf8\ub9b0\ub780\ub4dc \ub3d9\ubd80 \uc2dc\uac04",
               "EGT",
            };
        final String[] Gulf = new String[] {
               "\uac78\ud504\ub9cc \ud45c\uc900\uc2dc",
               "GST",
               "Gulf Daylight Time",
               "GDT",
               "Gulf Time",
               "GT",
            };
        final String[] Indonesia_Eastern = new String[] {
               "\ub3d9\ubd80 \uc778\ub3c4\ub124\uc2dc\uc544 \uc2dc\uac04",
               "WIT",
               "East Indonesia Summer Time",
               "EIST",
               "East Indonesia Time",
               "WIT",
            };
        final String[] Korea = new String[] {
               "\ub300\ud55c\ubbfc\uad6d \ud45c\uc900\uc2dc",
               "KST",
               "\ub300\ud55c\ubbfc\uad6d \ud558\uacc4 \ud45c\uc900\uc2dc",
               "KDT",
               "\ub300\ud55c\ubbfc\uad6d \uc2dc\uac04",
               "KT",
            };
        final String[] Australia_Western = new String[] {
               "\uc624\uc2a4\ud2b8\ub808\uc77c\ub9ac\uc544 \uc11c\ubd80 \ud45c\uc900\uc2dc",
               "AWST",
               "\uc624\uc2a4\ud2b8\ub808\uc77c\ub9ac\uc544 \uc11c\ubd80 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "AWDT",
               "\uc624\uc2a4\ud2b8\ub808\uc77c\ub9ac\uc544 \uc11c\ubd80 \uc2dc\uac04",
               "AWT",
            };
        final String[] Kyrgystan = new String[] {
               "\ud0a4\ub974\uae30\uc2a4\uc2a4\ud0c4 \uc2dc\uac04",
               "KGT",
               "Kirgizstan Summer Time",
               "KGST",
               "Kirgizstan Time",
               "KGT",
            };
        final String[] Indonesia_Western = new String[] {
               "\uc11c\ubd80 \uc778\ub3c4\ub124\uc2dc\uc544 \uc2dc\uac04",
               "WIB",
               "West Indonesia Summer Time",
               "WIST",
               "West Indonesia Time",
               "WIB",
            };
        final String[] Australia_Eastern = new String[] {
               "\uc624\uc2a4\ud2b8\ub808\uc77c\ub9ac\uc544 \ub3d9\ubd80 \ud45c\uc900\uc2dc",
               "AEST",
               "\uc624\uc2a4\ud2b8\ub808\uc77c\ub9ac\uc544 \ub3d9\ubd80 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "AEDT",
               "\uc624\uc2a4\ud2b8\ub808\uc77c\ub9ac\uc544 \ub3d9\ubd80 \uc2dc\uac04",
               "AET",
            };
        final String[] French_Guiana = new String[] {
               "\ud504\ub791\uc2a4\ub839 \uac00\uc774\uc544\ub098 \uc2dc\uac04",
               "GFT",
               "French Guiana Summer Time",
               "GFST",
               "French Guiana Time",
               "GFT",
            };
        final String[] Colombia = new String[] {
               "\ucf5c\ub86c\ube44\uc544 \ud45c\uc900\uc2dc",
               "COT",
               "\ucf5c\ub86c\ube44\uc544 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "COST",
               "\ucf5c\ub86c\ube44\uc544 \uc2dc\uac04",
               "COT",
            };
        final String[] Chile = new String[] {
               "\uce60\ub808 \ud45c\uc900\uc2dc",
               "CLT",
               "\uce60\ub808 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "CLST",
               "\uce60\ub808 \uc2dc\uac04",
               "CLT",
            };
        final String[] Gilbert_Islands = new String[] {
               "\uae38\ubc84\ud2b8 \uc81c\ub3c4 \uc2dc\uac04",
               "GILT",
               "Gilbert Is. Summer Time",
               "GILST",
               "Gilbert Is. Time",
               "GILT",
            };
        final String[] America_Mountain = new String[] {
               "\ubbf8 \uc0b0\uc545 \ud45c\uc900\uc2dc",
               "MST",
               "\ubbf8 \uc0b0\uc9c0 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "MDT",
               "\ubbf8 \uc0b0\uc9c0 \uc2dc\uac04",
               "MT",
            };
        final String[] Marquesas = new String[] {
               "\ub9c8\ub974\ud0a4\uc988 \uc81c\ub3c4 \uc2dc\uac04",
               "MART",
               "Marquesas Summer Time",
               "MARST",
               "Marquesas Time",
               "MART",
            };
        final String[] Arabian = new String[] {
               "\uc544\ub77c\ube44\uc544 \ud45c\uc900\uc2dc",
               "AST",
               "\uc544\ub77c\ube44\uc544 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "ADT",
               "\uc544\ub77c\ube44\uc544 \uc2dc\uac04",
               "AT",
            };
        final String[] Alaska = new String[] {
               "\uc54c\ub798\uc2a4\uce74 \ud45c\uc900\uc2dc",
               "AKST",
               "\uc54c\ub798\uc2a4\uce74 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "AKDT",
               "\uc54c\ub798\uc2a4\uce74 \uc2dc\uac04",
               "AKT",
            };
        final String[] Vladivostok = new String[] {
               "\ube14\ub77c\ub514\ubcf4\uc2a4\ud1a0\ud06c \ud45c\uc900\uc2dc",
               "VLAT",
               "\ube14\ub77c\ub514\ubcf4\uc2a4\ud1a0\ud06c \ud558\uacc4 \ud45c\uc900\uc2dc",
               "VLAST",
               "\ube14\ub77c\ub514\ubcf4\uc2a4\ud1a0\ud06c \uc2dc\uac04",
               "VLAT",
            };
        final String[] Chamorro = new String[] {
               "\ucc28\ubaa8\ub85c \uc2dc\uac04",
               "ChST",
               "Chamorro Daylight Time",
               "ChDT",
               "Chamorro Time",
               "ChT",
            };
        final String[] Irkutsk = new String[] {
               "\uc774\ub974\ucfe0\uce20\ud06c \ud45c\uc900\uc2dc",
               "IRKT",
               "\uc774\ub974\ucfe0\uce20\ud06c \ud558\uacc4 \ud45c\uc900\uc2dc",
               "IRKST",
               "\uc774\ub974\ucfe0\uce20\ud06c \uc2dc\uac04",
               "IRKT",
            };
        final String[] Georgia = new String[] {
               "\uadf8\ub8e8\uc9c0\uc544 \ud45c\uc900\uc2dc",
               "GET",
               "\uadf8\ub8e8\uc9c0\uc544 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "GEST",
               "\uadf8\ub8e8\uc9c0\uc544 \uc2dc\uac04",
               "GET",
            };
        final String[] Tokelau = new String[] {
               "\ud1a0\ucf08\ub77c\uc6b0 \uc2dc\uac04",
               "TKT",
               "Tokelau Summer Time",
               "TKST",
               "Tokelau Time",
               "TKT",
            };
        final String[] Papua_New_Guinea = new String[] {
               "\ud30c\ud478\uc544\ub274\uae30\ub2c8 \uc2dc\uac04",
               "PGT",
               "Papua New Guinea Summer Time",
               "PGST",
               "Papua New Guinea Time",
               "PGT",
            };
        final String[] Noronha = new String[] {
               "\ud398\ub974\ub09c\ub3c4 \ub370 \ub178\ub85c\ub0d0 \ud45c\uc900\uc2dc",
               "FNT",
               "\ud398\ub974\ub09c\ub3c4 \ub370 \ub178\ub85c\ub0d0 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "FNST",
               "\ud398\ub974\ub09c\ub3c4 \ub370 \ub178\ub85c\ub0d0 \uc2dc\uac04",
               "FNT",
            };
        final String[] Choibalsan = new String[] {
               "\ucd08\uc774\ubc1c\uc0b0 \ud45c\uc900\uc2dc",
               "CHOT",
               "\ucd08\uc774\ubc1c\uc0b0 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "CHOST",
               "\ucd08\uc774\ubc1c\uc0b0 \uc2dc\uac04",
               "CHOT",
            };
        final String[] Brasilia = new String[] {
               "\ube0c\ub77c\uc9c8\ub9ac\uc544 \ud45c\uc900\uc2dc",
               "BRT",
               "\ube0c\ub77c\uc9c8\ub9ac\uc544 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "BRST",
               "\ube0c\ub77c\uc9c8\ub9ac\uc544 \uc2dc\uac04",
               "BRT",
            };
        final String[] China = new String[] {
               "\uc911\uad6d \ud45c\uc900\uc2dc",
               "CST",
               "\uc911\uad6d \ud558\uacc4 \ud45c\uc900\uc2dc",
               "CDT",
               "\uc911\uad6d \uc2dc\uac04",
               "CT",
            };
        final String[] Armenia = new String[] {
               "\uc544\ub974\uba54\ub2c8\uc544 \ud45c\uc900\uc2dc",
               "AMT",
               "\uc544\ub974\uba54\ub2c8\uc544 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "AMST",
               "\uc544\ub974\uba54\ub2c8\uc544 \uc2dc\uac04",
               "AMT",
            };
        final String[] Samara = new String[] {
               "\uc0ac\ub9c8\ub77c \ud45c\uc900\uc2dc",
               "SAMT",
               "\uc0ac\ub9c8\ub77c \ud558\uacc4 \ud45c\uc900\uc2dc",
               "SAMST",
               "\uc0ac\ub9c8\ub77c \uc2dc\uac04",
               "SAMT",
            };
        final String[] India = new String[] {
               "\uc778\ub3c4 \ud45c\uc900\uc2dc",
               "IST",
               "India Daylight Time",
               "IDT",
               "India Time",
               "IT",
            };
        final String[] Cook = new String[] {
               "\ucfe1 \uc81c\ub3c4 \ud45c\uc900\uc2dc",
               "CKT",
               "\ucfe1 \uc81c\ub3c4 \uc808\ubc18 \ud558\uacc4 \ud45c\uc900\uc2dc",
               "CKHST",
               "\ucfe1 \uc81c\ub3c4 \uc2dc\uac04",
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
                    "\uadf8\ub9ac\ub2c8\uce58 \ud45c\uc900\uc2dc",
                    "GMT",
                    "\uc601\uad6d \ud558\uacc4 \ud45c\uc900\uc2dc",
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
            { "America/Eirunepe", Acre },
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
                    "\uadf8\ub9ac\ub2c8\uce58 \ud45c\uc900\uc2dc",
                    "GMT",
                    "\uc544\uc77c\ub79c\ub4dc \uc2dc\uac04",
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
            { "America/Rio_Branco", Acre },
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
