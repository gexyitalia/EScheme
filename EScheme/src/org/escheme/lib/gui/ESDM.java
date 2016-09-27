package org.escheme.lib.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.UIManager;

import org.escheme.Escheme;
import org.escheme.lib.gui.frame.ESFrame;
import org.escheme.lib.gui.panel.ESDrawPanel;

/**
 * Questa classe implementa un "desktop manager" tinene traccia e gestisce le centralmente le finestre
 */
public class ESDM {
	/*
	 * Theme
	 */
	public static final Color UI_BACKGROUND_COLOR=new Color(80,80,80); //color comune di backgrouind
	public static final Color UI_FOREGROUND_COLOR=Color.LIGHT_GRAY; //colore comune del testo
	public static final Color UI_BORDER_COLOR=Color.DARK_GRAY; //colore comune bordi
	public static final Color UI_SELECTION_BACKGROUND_COLOR=new Color(107,159,183); //colore background selezione comune
	
	public static final Color UI_MENU_BACKGROUND_COLOR=new Color(94,94,94); //colore background dei menu
	
	
	public static final Color UI_TEXTAREA_BACKGROUND_COLOR=new Color(55,55,55); //colore background dei textarea
	
	
	private void makeTheme(){
		

//		AbstractButton.clickText
//		AbstractDocument.additionText
//		AbstractDocument.deletionText
//		AbstractDocument.redoText
//		AbstractDocument.styleChangeText
//		AbstractDocument.undoText
//		AbstractUndoableEdit.redoText
//		AbstractUndoableEdit.undoText
//		AuditoryCues.allAuditoryCues
//		AuditoryCues.cueList
//		AuditoryCues.noAuditoryCues
		UIManager.getDefaults().put("Button.background", UI_BACKGROUND_COLOR);
		UIManager.getDefaults().put("Button.border", BorderFactory.createLineBorder(UI_BORDER_COLOR,1));
//		Button.darkShadow
//		Button.defaultButtonFollowsFocus
//		Button.disabledText
//		Button.focusInputMap
		UIManager.getDefaults().put("Button.font", new Font(getFont().getName(),Font.PLAIN,11));
		UIManager.getDefaults().put("Button.foreground", UI_FOREGROUND_COLOR);
//		Button.highlight
//		Button.light
		UIManager.getDefaults().put("Button.margin", new Insets(20,20,20,20));
//		Button.opaque
//		Button.select
//		Button.shadow
//		Button.textIconGap
//		Button.textShiftOffset
//		ButtonUI
		
//		CheckBox.background
//		CheckBox.border
//		CheckBox.disabledText
//		CheckBox.focusInputMap
//		CheckBox.font
//		CheckBox.foreground
//		CheckBox.icon
//		CheckBox.margin
//		CheckBox.select
//		CheckBox.textIconGap
//		CheckBox.textShiftOffset
		UIManager.getDefaults().put("CheckBoxMenuItem.font", new Font(getFont().getName(),Font.PLAIN,11));
		UIManager.getDefaults().put("CheckBoxMenuItem.foreground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("CheckBoxMenuItem.background", UI_BACKGROUND_COLOR);
//		CheckBoxMenuItem.acceleratorDelimiter
//		CheckBoxMenuItem.acceleratorFont
//		CheckBoxMenuItem.acceleratorForeground
//		CheckBoxMenuItem.acceleratorSelectionForeground
//		CheckBoxMenuItem.arrowIcon
//		CheckBoxMenuItem.border
//		CheckBoxMenuItem.borderPainted
//		CheckBoxMenuItem.checkIcon
//		CheckBoxMenuItem.dashIcon
//		CheckBoxMenuItem.disabledBackground
//		CheckBoxMenuItem.disabledForeground
//		CheckBoxMenuItem.margin
//		CheckBoxMenuItem.selectionBackground
//		CheckBoxMenuItem.selectionForeground
//		CheckBoxMenuItemUI
//		CheckBoxUI
//		ColorChooser.background
//		ColorChooser.cancelText
//		ColorChooser.font
//		ColorChooser.foreground
//		ColorChooser.hsbBlueText
//		ColorChooser.hsbBrightnessText
//		ColorChooser.hsbDisplayedMnemonicIndex
//		ColorChooser.hsbGreenText
//		ColorChooser.hsbHueText
//		ColorChooser.hsbMnemonic
//		ColorChooser.hsbNameText
//		ColorChooser.hsbRedText
//		ColorChooser.hsbSaturationText
//		ColorChooser.okText
//		ColorChooser.previewText
//		ColorChooser.resetMnemonic
//		ColorChooser.resetText
//		ColorChooser.rgbBlueMnemonic
//		ColorChooser.rgbBlueText
//		ColorChooser.rgbDisplayedMnemonicIndex
//		ColorChooser.rgbGreenMnemonic
//		ColorChooser.rgbGreenText
//		ColorChooser.rgbMnemonic
//		ColorChooser.rgbNameText
//		ColorChooser.rgbRedMnemonic
//		ColorChooser.rgbRedText
//		ColorChooser.sampleText
//		ColorChooser.swatchesDefaultRecentColor
//		ColorChooser.swatchesDisplayedMnemonicIndex
//		ColorChooser.swatchesMnemonic
//		ColorChooser.swatchesNameText
//		ColorChooser.swatchesRecentSwatchSize
//		ColorChooser.swatchesRecentText
//		ColorChooser.swatchesSwatchSize
//		ColorChooserUI
//		ComboBox.ancestorInputMap
//		ComboBox.background
//		ComboBox.buttonBackground
//		ComboBox.buttonDarkShadow
//		ComboBox.buttonHighlight
//		ComboBox.buttonShadow
//		ComboBox.disabledBackground
//		ComboBox.disabledForeground
//		ComboBox.font
//		ComboBox.foreground
//		ComboBox.isEnterSelectablePopup
//		ComboBox.selectionBackground
//		ComboBox.selectionForeground
//		ComboBox.timeFactor
//		ComboBox.togglePopupText
//		ComboBoxUI
//		Desktop.ancestorInputMap
		UIManager.getDefaults().put("Desktop.background", UI_BACKGROUND_COLOR);
//		Desktop.minOnScreenInsets
//		DesktopIcon.border
//		DesktopIconUI
//		DesktopPaneUI
//		EditorPane.background
//		EditorPane.border
//		EditorPane.caretBlinkRate
//		EditorPane.caretForeground
//		EditorPane.focusInputMap
//		EditorPane.font
//		EditorPane.foreground
//		EditorPane.inactiveBackground
//		EditorPane.inactiveForeground
//		EditorPane.margin
//		EditorPane.selectionBackground
//		EditorPane.selectionForeground
//		EditorPaneUI
//		FileChooser.acceptAllFileFilterText
//		FileChooser.ancestorInputMap
//		FileChooser.byDateText
//		FileChooser.byNameText
//		FileChooser.cancelButtonMnemonic
//		FileChooser.cancelButtonText
//		FileChooser.chooseButtonText
//		FileChooser.createButtonText
//		FileChooser.desktopName
//		FileChooser.detailsViewIcon
//		FileChooser.directoryDescriptionText
//		FileChooser.directoryOpenButtonMnemonic
//		FileChooser.directoryOpenButtonText
//		FileChooser.fileDescriptionText
//		FileChooser.fileNameLabelMnemonic
//		FileChooser.fileNameLabelText
//		FileChooser.fileSizeGigaBytes
//		FileChooser.fileSizeKiloBytes
//		FileChooser.fileSizeMegaBytes
//		FileChooser.filesOfTypeLabelMnemonic
//		FileChooser.filesOfTypeLabelText
//		FileChooser.helpButtonMnemonic
//		FileChooser.helpButtonText
//		FileChooser.homeFolderIcon
//		FileChooser.listViewIcon
//		FileChooser.lookInLabelMnemonic
//		FileChooser.mac.newFolder
//		FileChooser.mac.newFolder.subsequent
//		FileChooser.newFolderAccessibleName
//		FileChooser.newFolderButtonText
//		FileChooser.newFolderErrorSeparator
//		FileChooser.newFolderErrorText
//		FileChooser.newFolderExistsErrorText
//		FileChooser.newFolderIcon
//		FileChooser.newFolderPromptText
//		FileChooser.newFolderTitleText
//		FileChooser.openButtonMnemonic
//		FileChooser.openButtonText
//		FileChooser.openDialogTitleText
//		FileChooser.openTitleText
//		FileChooser.readOnly
//		FileChooser.saveButtonMnemonic
//		FileChooser.saveButtonText
//		FileChooser.saveDialogFileNameLabelText
//		FileChooser.saveDialogTitleText
//		FileChooser.saveTitleText
//		FileChooser.untitledFileName
//		FileChooser.untitledFolderName
//		FileChooser.upFolderIcon
//		FileChooser.updateButtonMnemonic
//		FileChooser.updateButtonText
//		FileChooser.useSystemExtensionHiding
//		FileChooser.usesSingleFilePane
//		FileChooserUI
//		FileView.computerIcon
//		FileView.directoryIcon
//		FileView.fileIcon
//		FileView.floppyDriveIcon
//		FileView.hardDriveIcon
//		Focus.color
//		FormView.browseFileButtonText
//		FormView.resetButtonText
//		FormView.submitButtonText
//		FormattedTextField.background
//		FormattedTextField.border
//		FormattedTextField.caretBlinkRate
//		FormattedTextField.caretForeground
//		FormattedTextField.focusInputMap
//		FormattedTextField.font
//		FormattedTextField.foreground
//		FormattedTextField.inactiveBackground
//		FormattedTextField.inactiveForeground
//		FormattedTextField.margin
//		FormattedTextField.selectionBackground
//		FormattedTextField.selectionForeground
//		FormattedTextFieldUI
//		IconButton.font
//		InsetBorder.aquaVariant
		UIManager.getDefaults().put("InternalFrame.background", UI_BACKGROUND_COLOR);
//		InternalFrame.activeTitleBackground
//		InternalFrame.activeTitleForeground
//		InternalFrame.borderColor
//		InternalFrame.borderDarkShadow
//		InternalFrame.borderHighlight
//		InternalFrame.borderLight
//		InternalFrame.borderShadow
//		InternalFrame.closeButtonToolTip
//		InternalFrame.closeIcon
//		InternalFrame.iconButtonToolTip
//		InternalFrame.iconifyIcon
//		InternalFrame.inactiveTitleBackground
//		InternalFrame.inactiveTitleForeground
//		InternalFrame.maxButtonToolTip
//		InternalFrame.maximizeIcon
//		InternalFrame.minimizeIcon
//		InternalFrame.opaque
//		InternalFrame.optionDialogBackground
//		InternalFrame.optionDialogTitleFont
//		InternalFrame.paletteBackground
//		InternalFrame.paletteTitleFont
//		InternalFrame.restoreButtonToolTip
//		InternalFrame.titleFont
//		InternalFrame.windowBindings
//		InternalFrameTitlePane.closeButtonAccessibleName
//		InternalFrameTitlePane.closeButtonOpacity
//		InternalFrameTitlePane.closeButtonText
//		InternalFrameTitlePane.iconifyButtonAccessibleName
//		InternalFrameTitlePane.iconifyButtonOpacity
//		InternalFrameTitlePane.maximizeButtonAccessibleName
//		InternalFrameTitlePane.maximizeButtonOpacity
//		InternalFrameTitlePane.maximizeButtonText
//		InternalFrameTitlePane.minimizeButtonText
//		InternalFrameTitlePane.moveButtonText
//		InternalFrameTitlePane.restoreButtonText
//		InternalFrameTitlePane.sizeButtonText
//		InternalFrameUI
//		IsindexView.prompt
		UIManager.getDefaults().put("Label.background", UI_BACKGROUND_COLOR);
//		Label.disabledForeground
//		Label.disabledShadow
		UIManager.getDefaults().put("Label.font", new Font(getFont().getName(),Font.PLAIN,11));
		UIManager.getDefaults().put("Label.foreground", UI_FOREGROUND_COLOR);
//		Label.opaque
//		LabelUI
		UIManager.getDefaults().put("List.font", new Font(getFont().getName(),Font.PLAIN,11));
		UIManager.getDefaults().put("List.foreground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("List.background", UI_BACKGROUND_COLOR);
//		List.cellRenderer
//		List.dropLineColor
//		List.evenRowBackgroundPainter
//		List.focusCellHighlightBorder
//		List.focusInputMap
//		List.focusInputMap.RightToLeft
//		List.oddRowBackgroundPainter
		UIManager.getDefaults().put("List.selectionBackground", UI_SELECTION_BACKGROUND_COLOR);
		UIManager.getDefaults().put("List.selectionForeground", UI_FOREGROUND_COLOR);
//		List.sourceListBackgroundPainter
//		List.sourceListFocusedSelectionBackgroundPainter
//		List.sourceListSelectionBackgroundPainter
//		List.timeFactor
//		ListUI
//		Menu.acceleratorFont
//		Menu.acceleratorForeground
//		Menu.acceleratorSelectionForeground
//		Menu.arrowIcon
		UIManager.getDefaults().put("Menu.background", UI_BACKGROUND_COLOR);
//		Menu.border
//		Menu.borderPainted
//		Menu.checkIcon
//		Menu.consumesTabs
//		Menu.crossMenuMnemonic
		UIManager.getDefaults().put("Menu.selectionBackground", UI_SELECTION_BACKGROUND_COLOR);
		UIManager.getDefaults().put("Menu.selectionForeground", UI_FOREGROUND_COLOR);
//		Menu.disabledBackground
//		Menu.disabledForeground
		UIManager.getDefaults().put("Menu.font", new Font(getFont().getName(),Font.PLAIN,11));
		UIManager.getDefaults().put("Menu.foreground", UI_FOREGROUND_COLOR);
//		Menu.margin
//		Menu.menuPopupOffsetX
//		Menu.menuPopupOffsetY
//		Menu.shortcutKeys
//		Menu.submenuPopupOffsetX
//		Menu.submenuPopupOffsetY
		UIManager.getDefaults().put("MenuBar.background", UI_BACKGROUND_COLOR);
//		MenuBar.backgroundPainter
		UIManager.getDefaults().put("MenuBar.border", BorderFactory.createLineBorder(UI_BORDER_COLOR,1));
//		MenuBar.disabledBackground
//		MenuBar.disabledForeground
		UIManager.getDefaults().put("MenuBar.font", new Font(getFont().getName(),Font.PLAIN,11));
		UIManager.getDefaults().put("MenuBar.foreground", UI_FOREGROUND_COLOR);
//		MenuBar.highlight
//		MenuBar.margin
//		MenuBar.selectedBackgroundPainter
		UIManager.getDefaults().put("MenuBar.selectionBackground", UI_SELECTION_BACKGROUND_COLOR);
		UIManager.getDefaults().put("MenuBar.selectionForeground", UI_FOREGROUND_COLOR);
//		MenuBar.shadow
//		MenuBar.windowBindings
//		MenuBarUI
//		MenuItem.acceleratorDelimiter
//		MenuItem.acceleratorFont
//		MenuItem.acceleratorForeground
//		MenuItem.acceleratorSelectionForeground
//		MenuItem.arrowIcon
		UIManager.getDefaults().put("MenuItem.font", new Font(getFont().getName(),Font.PLAIN,11));
		UIManager.getDefaults().put("MenuItem.foreground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("MenuItem.background",UI_MENU_BACKGROUND_COLOR);
		UIManager.getDefaults().put("MenuItem.border", BorderFactory.createLineBorder(UI_BORDER_COLOR,0));
//		MenuItem.borderPainted
//		MenuItem.checkIcon
//		MenuItem.disabledBackground
//		MenuItem.disabledForeground
//		MenuItem.margin
//		MenuItem.selectedBackgroundPainter
		UIManager.getDefaults().put("MenuItem.selectionBackground", UI_SELECTION_BACKGROUND_COLOR);
		UIManager.getDefaults().put("MenuItem.selectionForeground", UI_FOREGROUND_COLOR);
//		MenuItemUI
//		MenuUI
//		OptionPane.background
//		OptionPane.border
//		OptionPane.buttonAreaBorder
//		OptionPane.buttonClickThreshhold
//		OptionPane.buttonFont
//		OptionPane.cancelButtonMnemonic
//		OptionPane.cancelButtonText
//		OptionPane.errorIcon
//		OptionPane.font
//		OptionPane.foreground
//		OptionPane.informationIcon
//		OptionPane.inputDialogTitle
//		OptionPane.messageAreaBorder
//		OptionPane.messageDialogTitle
//		OptionPane.messageFont
//		OptionPane.messageForeground
//		OptionPane.minimumSize
//		OptionPane.noButtonMnemonic
//		OptionPane.noButtonText
//		OptionPane.okButtonMnemonic
//		OptionPane.okButtonText
//		OptionPane.questionIcon
//		OptionPane.titleText
//		OptionPane.warningIcon
//		OptionPane.windowBindings
//		OptionPane.yesButtonMnemonic
//		OptionPane.yesButtonText
//		OptionPaneUI
		UIManager.getDefaults().put("Panel.foreground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("Panel.background", UI_BACKGROUND_COLOR);
		UIManager.getDefaults().put("Panel.font", new Font(getFont().getName(),Font.PLAIN,11));
//		Panel.opaque
//		PanelUI
//		PasswordField.background
//		PasswordField.border
//		PasswordField.caretBlinkRate
//		PasswordField.caretForeground
//		PasswordField.echoChar
//		PasswordField.focusInputMap
//		PasswordField.font
//		PasswordField.foreground
//		PasswordField.inactiveBackground
//		PasswordField.inactiveForeground
//		PasswordField.margin
//		PasswordField.selectionBackground
//		PasswordField.selectionForeground
//		PasswordFieldUI
		UIManager.getDefaults().put("PopupMenu.foreground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("PopupMenu.background", UI_BACKGROUND_COLOR);
		UIManager.getDefaults().put("PopupMenu.font", new Font(getFont().getName(),Font.PLAIN,11));
		UIManager.getDefaults().put("PopupMenu.border", BorderFactory.createLineBorder(UI_BORDER_COLOR,1));
//		PopupMenu.consumeEventOnClose
//		PopupMenu.selectedWindowInputMapBindings
//		PopupMenu.selectedWindowInputMapBindings.RightToLeft
//		PopupMenu.selectionBackground
//		PopupMenu.selectionForeground
//		PopupMenuSeparatorUI
//		PopupMenuUI
//		PrintingDialog.abortButtonDisplayedMnemonicIndex
//		PrintingDialog.abortButtonMnemonic
//		PrintingDialog.abortButtonText
//		PrintingDialog.abortButtonToolTipText
//		PrintingDialog.contentAbortingText
//		PrintingDialog.contentInitialText
//		PrintingDialog.contentProgressText
//		PrintingDialog.titleAbortingText
//		PrintingDialog.titleProgressText
//		ProgressBar.background
//		ProgressBar.border
//		ProgressBar.cellLength
//		ProgressBar.cellSpacing
//		ProgressBar.cycleTime
//		ProgressBar.font
//		ProgressBar.foreground
//		ProgressBar.horizontalSize
//		ProgressBar.repaintInterval
//		ProgressBar.selectionBackground
//		ProgressBar.selectionForeground
//		ProgressBar.verticalSize
//		ProgressBarUI
//		ProgressMonitor.progressText
//		RadioButton.background
//		RadioButton.border
//		RadioButton.darkShadow
//		RadioButton.disabledText
//		RadioButton.focusInputMap
//		RadioButton.font
//		RadioButton.foreground
//		RadioButton.highlight
//		RadioButton.icon
//		RadioButton.light
//		RadioButton.margin
//		RadioButton.select
//		RadioButton.shadow
//		RadioButton.textIconGap
//		RadioButton.textShiftOffset
//		RadioButtonMenuItem.acceleratorDelimiter
//		RadioButtonMenuItem.acceleratorFont
//		RadioButtonMenuItem.acceleratorForeground
//		RadioButtonMenuItem.acceleratorSelectionForeground
//		RadioButtonMenuItem.arrowIcon
//		RadioButtonMenuItem.background
//		RadioButtonMenuItem.border
//		RadioButtonMenuItem.borderPainted
//		RadioButtonMenuItem.checkIcon
//		RadioButtonMenuItem.dashIcon
//		RadioButtonMenuItem.disabledBackground
//		RadioButtonMenuItem.disabledForeground
//		RadioButtonMenuItem.font
//		RadioButtonMenuItem.foreground
//		RadioButtonMenuItem.margin
//		RadioButtonMenuItem.selectionBackground
//		RadioButtonMenuItem.selectionForeground
//		RadioButtonMenuItemUI
//		RadioButtonUI
//		RootPane.ancestorInputMap
//		RootPane.defaultButtonWindowKeyBindings
//		RootPaneUI
//		ScrollBar.ancestorInputMap
//		ScrollBar.ancestorInputMap.RightToLeft
//		ScrollBar.background
//		ScrollBar.focusInputMap
//		ScrollBar.focusInputMap.RightToLeft
//		ScrollBar.foreground
//		ScrollBar.maximumThumbSize
//		ScrollBar.minimumThumbSize
//		ScrollBar.thumb
//		ScrollBar.thumbDarkShadow
//		ScrollBar.thumbHighlight
//		ScrollBar.thumbShadow
//		ScrollBar.track
//		ScrollBar.trackHighlight
//		ScrollBar.width
//		ScrollBarUI
//		ScrollPane.ancestorInputMap
//		ScrollPane.ancestorInputMap.RightToLeft
//		ScrollPane.background
//		ScrollPane.border
//		ScrollPane.font
//		ScrollPane.foreground
//		ScrollPaneUI
		UIManager.getDefaults().put("Separator.foreground", UI_FOREGROUND_COLOR);
//		Separator.highlight
//		Separator.shadow
//		SeparatorUI
//		Slider.background
//		Slider.focus
//		Slider.focusInputMap
//		Slider.focusInputMap.RightToLeft
//		Slider.focusInsets
//		Slider.font
//		Slider.foreground
//		Slider.highlight
//		Slider.horizontalSize
//		Slider.minimumHorizontalSize
//		Slider.minimumVerticalSize
//		Slider.shadow
//		Slider.tickColor
//		Slider.verticalSize
//		SliderUI
//		Spinner.ancestorInputMap
//		Spinner.arrowButtonSize
//		Spinner.background
//		Spinner.editorAlignment
//		Spinner.editorBorderPainted
//		Spinner.font
//		Spinner.foreground
//		SpinnerUI
//		SplitPane.ancestorInputMap
//		SplitPane.background
//		SplitPane.border
//		SplitPane.darkShadow
//		SplitPane.dividerSize
//		SplitPane.highlight
//		SplitPane.leftButtonText
//		SplitPane.rightButtonText
//		SplitPane.shadow
//		SplitPaneDivider.draggingColor
//		SplitPaneDivider.horizontalGradientVariant
//		SplitPaneUI
		UIManager.getDefaults().put("TabbedPane.font", new Font(getFont().getName(),Font.PLAIN,11));
		UIManager.getDefaults().put("TabbedPane.foreground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("TabbedPane.background", UI_BACKGROUND_COLOR);
//		TabbedPane.ancestorInputMap
//		TabbedPane.contentBorderInsets
//		TabbedPane.contentOpaque
//		TabbedPane.darkShadow
//		TabbedPane.focus
//		TabbedPane.focusInputMap
//		TabbedPane.highlight
//		TabbedPane.leftTabInsets
//		TabbedPane.light
//		TabbedPane.opaque
//		TabbedPane.rightTabInsets
//		TabbedPane.selectedTabPadInsets
//		TabbedPane.shadow
//		TabbedPane.smallFont
//		TabbedPane.tabAreaInsets
//		TabbedPane.tabInsets
//		TabbedPane.tabRunOverlay
//		TabbedPane.tabsOpaque
//		TabbedPane.tabsOverlapBorder
//		TabbedPane.textIconGap
//		TabbedPane.useSmallLayout
//		TabbedPaneUI
		UIManager.getDefaults().put("Table.font", new Font(getFont().getName(),Font.PLAIN,11));
		UIManager.getDefaults().put("Table.foreground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("Table.background", UI_BACKGROUND_COLOR);
//		Table.ancestorInputMap
//		Table.ancestorInputMap.RightToLeft
//		Table.ascendingSortIcon
//		Table.descendingSortIcon
//		Table.dropLineColor
//		Table.dropLineShortColor
//		Table.focusCellBackground
//		Table.focusCellForeground
//		Table.focusCellHighlightBorder
//		Table.gridColor
//		Table.scrollPaneBorder
//		Table.selectionBackground
//		Table.selectionForeground
//		Table.sortIconColor
		UIManager.getDefaults().put("TableHeader.font", new Font(getFont().getName(),Font.PLAIN,11));
		UIManager.getDefaults().put("TableHeader.foreground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("TableHeader.background", UI_BACKGROUND_COLOR);
//		TableHeader.ancestorInputMap
//		TableHeader.cellBorder
//		TableHeader.focusCellBackground
//		TableHeaderUI
//		TableUI
		UIManager.getDefaults().put("TextArea.foreground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("TextArea.background", UI_TEXTAREA_BACKGROUND_COLOR);
		UIManager.getDefaults().put("TextArea.border", BorderFactory.createLineBorder(UI_BORDER_COLOR,0));
//		TextArea.caretBlinkRate
//		TextArea.caretForeground
//		TextArea.focusInputMap
		UIManager.getDefaults().put("TextArea.font", new Font(getFont().getName(),Font.PLAIN,11));
//		TextArea.inactiveBackground
//		TextArea.inactiveForeground
//		TextArea.margin
//		TextArea.selectionBackground
//		TextArea.selectionForeground
//		TextAreaUI
//		TextComponent.selectionBackgroundInactive
		UIManager.getDefaults().put("TextField.foreground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("TextField.background", UI_TEXTAREA_BACKGROUND_COLOR);
		UIManager.getDefaults().put("TextField.border", BorderFactory.createLineBorder(UI_BORDER_COLOR,0));
//		TextField.caretBlinkRate
//		TextField.caretForeground
//		TextField.darkShadow
//		TextField.focusInputMap
		UIManager.getDefaults().put("TextField.font", new Font(getFont().getName(),Font.PLAIN,11));//		TextField.foreground
//		TextField.highlight
//		TextField.inactiveBackground
//		TextField.inactiveForeground
//		TextField.light
//		TextField.margin
//		TextField.selectionBackground
//		TextField.selectionForeground
//		TextField.shadow
//		TextFieldUI
//		TextPane.background
//		TextPane.border
//		TextPane.caretBlinkRate
//		TextPane.caretForeground
//		TextPane.focusInputMap
//		TextPane.font
//		TextPane.foreground
//		TextPane.inactiveBackground
//		TextPane.inactiveForeground
//		TextPane.margin
//		TextPane.selectionBackground
//		TextPane.selectionForeground
//		TextPaneUI
//		TitledBorder.aquaVariant
//		TitledBorder.border
//		TitledBorder.font
//		TitledBorder.titleColor
		UIManager.getDefaults().put("ToggleButton.background", UI_BACKGROUND_COLOR);
		UIManager.getDefaults().put("ToggleButton.foreground", UI_FOREGROUND_COLOR);
//		ToggleButton.border
//		ToggleButton.darkShadow
//		ToggleButton.disabledText
//		ToggleButton.focusInputMap
		UIManager.getDefaults().put("Tree.font", new Font(getFont().getName(),Font.PLAIN,11));
//		ToggleButton.highlight
//		ToggleButton.light
//		ToggleButton.margin
//		ToggleButton.shadow
//		ToggleButton.textIconGap
//		ToggleButton.textShiftOffset
//		ToggleButtonUI
//		ToolBar.ancestorInputMap
//		ToolBar.background
//		ToolBar.border
//		ToolBar.darkShadow
//		ToolBar.dockingBackground
//		ToolBar.dockingForeground
//		ToolBar.floatingBackground
//		ToolBar.floatingForeground
//		ToolBar.font
//		ToolBar.foreground
//		ToolBar.highlight
//		ToolBar.light
//		ToolBar.shadow
//		ToolBarButton.insets
//		ToolBarButton.margin
//		ToolBarSeparatorUI
//		ToolBarUI
//		ToolTip.background
//		ToolTip.border
//		ToolTip.font
//		ToolTip.foreground
//		ToolTipManager.enableToolTipMode
//		ToolTipUI
		UIManager.getDefaults().put("Tree.font", new Font(getFont().getName(),Font.PLAIN,11));
		UIManager.getDefaults().put("Tree.foreground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("Tree.background", UI_BACKGROUND_COLOR);
		UIManager.getDefaults().put("Tree.selectionBackground", UI_SELECTION_BACKGROUND_COLOR);
		UIManager.getDefaults().put("Tree.selectionForeground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("Tree.textForeground", UI_FOREGROUND_COLOR);
		UIManager.getDefaults().put("Tree.textBackground", UI_BACKGROUND_COLOR);
//		Tree.ancestorInputMap
//		Tree.changeSelectionWithFocus
//		Tree.closedIcon
//		Tree.collapsedIcon
//		Tree.drawsFocusBorderAroundIcon
//		Tree.dropLineColor
//		Tree.editorBorder
//		Tree.expandedIcon
//		Tree.focusInputMap
//		Tree.focusInputMap.RightToLeft
//		Tree.hash
//		Tree.leafIcon
//		Tree.leftChildIndent
//		Tree.line
//		Tree.lineTypeDashed
//		Tree.openIcon
//		Tree.paintLines
//		Tree.rightChildIndent
//		Tree.rightToLeftCollapsedIcon
//		Tree.rowHeight
//		Tree.scrollsOnExpand
//		Tree.selectionBorderColor
//		Tree.selectionForeground
//		Tree.textBackground
//		Tree.textForeground
//		Tree.timeFactor
//		TreeUI
//		Viewport.background
//		Viewport.font
//		Viewport.foreground
//		ViewportUI
//		_SecurityDecisionIcon
//		activeCaption
//		activeCaptionBorder
//		activeCaptionText
//		control
//		controlDkShadow
//		controlHighlight
//		controlLtHighlight
//		controlShadow
//		controlText
//		desktop
//		html.missingImage
//		html.pendingImage
//		inactiveCaption
//		inactiveCaptionBorder
//		inactiveCaptionText
//		info
//		infoText
//		menu
//		menuText
//		scrollbar
//		text
//		textHighlight
//		textHighlightText
//		textInactiveText
//		textText
//		window
//		windowBorder
//		windowText
	}
	
	/*
	 * gestione dei frame
	 */
	private ArrayList<ESFrame> frames = new ArrayList<ESFrame>();
	private Font font; //font
	
	public ESDM(){
		loadFont(); //caricamento dei font
		makeTheme();
	}

	/**
	 * Registra un nuovo frame, applicando se necessario un nuovo
	 * ID e un nuovo name
	 * @param _frame ESFrame
	 */
	public void addFrame(ESFrame _frame){
		frames.add(_frame); //aggiungo il frame alla lista
	}

	/**
	 * Carica i file dei Font
	 */
	private void loadFont(){
		//importo font
		Font ttfBase = null;
		font = null;
		InputStream myStream = null;
		try {
			myStream = new BufferedInputStream(new FileInputStream("font/OpenSans-CondLight.ttf"));
			ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
			font = ttfBase.deriveFont(Font.PLAIN, 24); 
		} catch (Exception e) {
			System.err.println("Font not loaded: "+e.getMessage());
		}


	}

	/**
	 * Restituisce l'oggeto font da utilizzare nella UI
	 * @return Font
	 */
	public Font getFont(){
		return font;
	}

	/**
	 * Rimuove un frame dalla lista frame, tramite UID del frame.
	 * @param _UID integer
	 * @return boolean Se true il frame è stato trovato e rimosso, se false non è stato trovato.
	 */
	public boolean removeFrame(int _UID){
		for(int a=0;a<frames.size();a++){
			if(frames.get(a).getUID()==_UID){
				frames.remove(a);
				return true;
			}
		}
		return false;
	}

	/**
	 * restituisce l'istanza di un frame dal suo UID
	 * @param _id integer
	 * @return ESFrame|null Se ritorna null non è stata tr4ovata un istanza con l'UID specificato nella lista frames
	 */
	public ESFrame getFrame(int _UID){
		for(int a=0;a<frames.size();a++){
			if(frames.get(a).getUID()==_UID){
				frames.get(a);
			}
		}
		return null;
	}

	/**
	 * Restituisce l'array contenitore di tutte le finestre
	 * @return ArrayList<ESFrame>
	 */
	public ArrayList<ESFrame> getFrames(){
		return frames;
	}

	/**
	 * Genera un ID univoco per i nuovi frame.
	 * Questo viene generato trovando l'ID maggiore tra tutti
	 * i frame e aggiungendo 1 a questo valore
	 */
	public int generateFrameUID(){
		int retVal=0,curID;
		for(int a=0; a<frames.size(); a++){
			curID=frames.get(a).getUID();
			if(curID>=retVal){retVal=curID+1;}else{continue;}
		}
		return retVal;
	}
	
	/*
	 * gestione dei pannelli disegno aperti
	 */
	private ArrayList<ESDrawPanel> drawPanels = new ArrayList<ESDrawPanel>();
	
	/**
	 * Aggiunge un pannello disegno alla lista pannelli di disegno
	 * @param _obj
	 */
	public void addDrawPanel(ESDrawPanel _obj){
		drawPanels.add(_obj);
	}
	
	/**
	 * Genera un ID univoco per i nuovi pannelli.
	 * Questo viene generato trovando l'ID maggiore tra tutti
	 * i pannelli e aggiungendo 1 a questo valore
	 */
	public int generateDrawPanelUID(){
		int retVal=0,curID;
		for(int a=0; a<drawPanels.size(); a++){
			curID=drawPanels.get(a).getUID();
			if(curID>=retVal){retVal=curID+1;}else{continue;}
		}
		return retVal;
	}
	
	/**
	 * Restituisce l'array contenitore di tutti i pannelli di disegno
	 * @return ArrayList<ESDrawPanel>
	 */
	public ArrayList<ESDrawPanel> getDrawPanels(){
		return drawPanels;
	}

}
