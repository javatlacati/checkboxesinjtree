package es.stackoverflow.com.questions484544;

import java.awt.Component;
import java.util.Optional;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class QuestionCellEditor extends DefaultCellEditor {

    protected TrueFalseTreeNodeData nodeData;

    public QuestionCellEditor() {
        super(new JCheckBox());
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value,
            boolean selected, boolean expanded, boolean leaf, int row) {
        JCheckBox editor = null;
        final Optional<DefaultMutableTreeNode> mutableNode = Optional.of(value)
                .filter(DefaultMutableTreeNode.class::isInstance)
                .map(DefaultMutableTreeNode.class::cast);

        nodeData = mutableNode
                .map(DefaultMutableTreeNode::getUserObject)
                .filter(TrueFalseTreeNodeData.class::isInstance)
                .map(TrueFalseTreeNodeData.class::cast)
                .orElse(null);

        if (nodeData != null) {
            editor = (JCheckBox) (super.getComponent());
            final boolean isSelected = nodeData.isBooleanValue();
            editor.doClick();
            editor.setText(nodeData.getValue());
            editor.setSelected(isSelected);
            updateChilds(mutableNode.get());
            tree.expandPath(tree.getAnchorSelectionPath());
        }
        return editor;
    }

    @Override
    public Object getCellEditorValue() {
        JCheckBox editor = (JCheckBox) (super.getComponent());
        nodeData.setBooleanValue(editor.isSelected());
        return nodeData;
    }

    private void updateChilds(DefaultMutableTreeNode node) {

        Object userObject = node.getUserObject();
        if (userObject instanceof TrueFalseTreeNodeData) {
            TrueFalseTreeNodeData uo = (TrueFalseTreeNodeData) userObject;
            if (!uo.isBooleanValue()) {
                for (int i = 0; i < node.getChildCount(); i++) {
                    DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
                    if(!childNode.isLeaf()){
                        updateChilds(childNode);
                    }
                    TrueFalseTreeNodeData childTreeNodeData = (TrueFalseTreeNodeData) childNode.getUserObject();
                    childTreeNodeData.setBooleanValue(true);
                    childNode.setUserObject(childTreeNodeData);
                    System.out.println("cn->"+childNode);
                }
            }
        }

    }
}
