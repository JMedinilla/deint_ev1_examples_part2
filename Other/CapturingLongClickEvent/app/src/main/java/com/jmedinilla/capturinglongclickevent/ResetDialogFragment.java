package com.jmedinilla.capturinglongclickevent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by lourdes on 2/11/16.
 */

public class ResetDialogFragment extends DialogFragment {

    private OnResetDialogListener listener;

    public interface OnResetDialogListener {
        void onPossitiveButtonClick();// Eventos Botón Positivo
        //void onNegativeButtonClick();// Eventos Botón Negativo
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnResetDialogListener)context;

        } catch (ClassCastException e) {
            throw new ClassCastException(
                    context.toString() +
                            " no implementó OnSimpleDialogListener");

        }
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setMessage(R.string.dialog_message_reset)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                listener.onPossitiveButtonClick();

                            }
                        })

                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                dismiss();
                            }
                        });

        return builder.create();
    }
}
