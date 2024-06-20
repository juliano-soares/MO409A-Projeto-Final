# Remove "exit" and "file"
DELETE FROM MENUITEM WHERE MNI_ID_A IN ('exit', 'file');
DELETE FROM GROUPMENU WHERE GM_MNI_ID_A IN ('exit', 'file');

# "General Data" is now "Settings" so change shortcut key
# Note: the label is set in the properties file
UPDATE MENUITEM SET MNI_SHORTCUT='S' WHERE MNI_ID_A='generaldata';

# Move the "Users" menu to the end of "Settings"
UPDATE MENUITEM SET MNI_SUBMENU="generaldata", MNI_POSITION=10 WHERE MNI_ID_A="users";

# Rearrange main menu
UPDATE MENUITEM SET MNI_POSITION=1 WHERE MNI_ID_A="opd";
UPDATE MENUITEM SET MNI_POSITION=2 WHERE MNI_ID_A="admission";
UPDATE MENUITEM SET MNI_POSITION=3 WHERE MNI_ID_A="laboratory";
UPDATE MENUITEM SET MNI_POSITION=4 WHERE MNI_ID_A="pharmacy";
UPDATE MENUITEM SET MNI_POSITION=5 WHERE MNI_ID_A="patientvaccine";
UPDATE MENUITEM SET MNI_POSITION=6 WHERE MNI_ID_A="accounting";
UPDATE MENUITEM SET MNI_POSITION=7 WHERE MNI_ID_A="worksheet";
UPDATE MENUITEM SET MNI_POSITION=8 WHERE MNI_ID_A="statistics";
UPDATE MENUITEM SET MNI_POSITION=9 WHERE MNI_ID_A="printing";
UPDATE MENUITEM SET MNI_POSITION=10 WHERE MNI_ID_A="communication";
UPDATE MENUITEM SET MNI_POSITION=11 WHERE MNI_ID_A="generaldata";
UPDATE MENUITEM SET MNI_POSITION=12 WHERE MNI_ID_A="help";
